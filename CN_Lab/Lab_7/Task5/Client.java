import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) {
        final String SERVER_HOST = "localhost";
        final int SERVER_PORT = 5009;

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            Scanner scanner = new Scanner(System.in);

            // User input for configuration
            System.out.print("Enter window size: ");
            int WINDOW_SIZE = scanner.nextInt();

            System.out.print("Enter total number of frames to send: ");
            int totalFrames = scanner.nextInt();

            int base = 1;       // Sequence number of the oldest unacknowledged frame
            int nextSeqNum = 1; // Next frame to send

            // Sliding window loop
            while (base <= totalFrames) {

                // Send frames within the window
                while (nextSeqNum < base + WINDOW_SIZE && nextSeqNum <= totalFrames) {
                    System.out.println("Sending frame: " + nextSeqNum);
                    out.println(nextSeqNum); // Send frame as sequence number string
                    nextSeqNum++;
                }

                // Wait for ACK with timeout
                socket.setSoTimeout(5000); // 5-second timeout
                try {
                    String ackStr = in.readLine();
                    if (ackStr != null && ackStr.startsWith("ACK ")) {
                        int ackNum = Integer.parseInt(ackStr.substring(4));
                        System.out.println("Received cumulative ACK: " + ackNum);

                        // Slide window if ACK is valid
                        if (ackNum >= base) {
                            base = ackNum + 1;
                        }
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout! Retransmitting from frame: " + base);
                    nextSeqNum = base; // Go back and resend from base
                }
            }

            // Notify server of end of transmission
            out.println("END");
            System.out.println("All frames sent and acknowledged. Transmission complete.");

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
