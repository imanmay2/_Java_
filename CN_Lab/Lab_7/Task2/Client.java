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

            int i = 0;
            while (i < n) {
                System.out.println("Sending frame: " + frames[i]);
                out.println(frames[i]);

                // Special handling for frame "2" (simulate retransmission on loss)
                if (frames[i].equals("2")) {
                    int attempts = 0;
                    boolean ackReceived = false;

                    socket.setSoTimeout(2000); // wait up to 2 seconds for ACK

                    while (attempts < 1 && !ackReceived) {
                        try {
                            String ack = in.readLine();
                            if (ack != null && ack.equals("ACK " + frames[i])) {
                                System.out.println("Received: " + ack);
                                ackReceived = true;
                            }
                        } catch (SocketTimeoutException e) {
                            attempts++;
                            System.out.println("ACK not received for frame 2, retrying (" + attempts + ")");
                            out.println(frames[i]); // retransmit
                        }
                    }

                    if (!ackReceived) {
                        System.out.println("Failed to receive ACK for frame 2 after retries. Stopping transmission.");
                        break; // stop transmission if ACK never received
                    }

                } else {
                    // Normal case: wait for ACK
                    String ack = in.readLine();
                    System.out.println("Received: " + ack);
                }

                i++;
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
