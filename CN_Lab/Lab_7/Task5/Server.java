import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        final int PORT = 5009;
        boolean packet2LostOnce = false; // To simulate loss of frame 2 only once

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

            int expectedSeq = 1; // Next frame sequence number expected
            String frame;

            // Process incoming frames
            while ((frame = in.readLine()) != null) {
                if (frame.equalsIgnoreCase("END")) {
                    break; // End of transmission
                }

                int frameSeq = Integer.parseInt(frame);

                // Simulate packet loss for frame 2 (first occurrence only)
                if (frameSeq == 2 && !packet2LostOnce) {
                    System.out.println("Simulating loss: Data packet 2 dropped (first time).");
                    packet2LostOnce = true;
                    continue; // Do not ACK this frame
                }

                // Case 1: Expected frame received
                if (frameSeq == expectedSeq) {
                    System.out.println("Received expected frame: " + frameSeq);
                    expectedSeq++;

                    // Send cumulative ACK
                    out.println("ACK " + (expectedSeq - 1));
                    System.out.println("Sent cumulative ACK: " + (expectedSeq - 1));
                }
                // Case 2: Out-of-order or duplicate frame received
                else {
                    System.out.println(
                        "Discarded out-of-order/duplicate frame: " + frameSeq +
                        ", expected: " + expectedSeq
                    );

                    // Resend last cumulative ACK
                    out.println("ACK " + (expectedSeq - 1));
                    System.out.println("Resent cumulative ACK: " + (expectedSeq - 1));
                }
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
