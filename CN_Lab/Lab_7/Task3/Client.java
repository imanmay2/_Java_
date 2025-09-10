import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 5009;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            // Ask user how many frames to send
            System.out.print("Enter number of frames to send: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Store frames
            String[] frames = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter data for frame " + (i + 1) + ": ");
                frames[i] = scanner.nextLine();
            }

            boolean ack1Lost = false; // to simulate ACK loss for frame 1
            int i = 0;

            while (i < n) {
                System.out.println("Sending frame: " + frames[i]);
                out.println(frames[i]);

                socket.setSoTimeout(2000); // wait max 2 seconds for ACK

                try {
                    String ack = in.readLine();

                    // Simulate ACK loss for frame "1"
                    if (frames[i].equals("1") && !ack1Lost) {
                        System.out.println("Simulating loss of ACK for frame 1.");
                        ack1Lost = true; // only simulate once
                        throw new SocketTimeoutException();
                    }

                    // Normal ACK reception
                    if (ack != null && ack.equals("ACK " + frames[i])) {
                        System.out.println("Received: " + ack);
                        i++; // move to next frame
                    }

                } catch (SocketTimeoutException e) {
                    // Retransmit same frame
                    System.out.println("ACK not received for frame " + frames[i] + ", resending...");
                }
            }

            // End transmission
            out.println("END");
            System.out.println("All frames sent. Connection closed.");

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

