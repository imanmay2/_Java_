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

            int expectedSeq = 1; // The next frame sequence number expected
            String frame;

            // Process incoming frames
            while ((frame = in.readLine()) != null) {
                if (frame.equalsIgnoreCase("END")) {
                    break; // End of transmission
                }

                int frameSeq = Integer.parseInt(frame);

                if (frameSeq == expectedSeq) {
                    System.out.println("Received expected frame: " + frameSeq);
                    expectedSeq++;
                } else {
                    System.out.println(
                        "Received out-of-order frame: " + frameSeq +
                        ", but expected: " + expectedSeq
                    );
                }

                // Send cumulative ACK for all frames up to expectedSeq - 1
                out.println("ACK " + (expectedSeq - 1));
                System.out.println("Sent cumulative ACK: " + (expectedSeq - 1));
            }

            // Close client connection
            clientSocket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
