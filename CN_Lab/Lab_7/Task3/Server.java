import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        final int PORT = 5009;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client on port " + PORT + "...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Setup input/output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Process incoming frames
            String frame;
            while ((frame = in.readLine()) != null) {
                if (frame.equalsIgnoreCase("END")) {
                    break; // End of transmission
                }

                // Print received frame
                System.out.println("Received frame: " + frame);

                // Send acknowledgment
                out.println("ACK " + frame);
                System.out.println("Sent ACK for frame: " + frame);
            }

            // Close client socket
            clientSocket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
