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

            // Store frame data
            String[] frames = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter data for frame " + (i + 1) + ": ");
                frames[i] = scanner.nextLine();
            }

            // Send frames one by one
            for (int i = 0; i < n; i++) {
                System.out.println("Sending frame: " + frames[i]);
                out.println(frames[i]);

                // Wait for acknowledgment
                String ack = in.readLine();
                System.out.println("Received acknowledgment: " + ack);
            }

            // Indicate end of transmission
            out.println("END");

            System.out.println("All frames sent. Connection closing...");

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}