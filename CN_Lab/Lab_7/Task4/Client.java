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

            // Input: window size and total frames
            System.out.print("Enter window size: ");
            int WINDOW_SIZE = scanner.nextInt();

            System.out.print("Enter total number of frames to send: ");
            int totalFrames = scanner.nextInt();

            int base = 1;        // Sequence number of the oldest unacknowledged frame
            int nextSeqNum = 1;  // Next frame to send

            while (base <= totalFrames) {
                // Send frames within window
                while (nextSeqNum < base + WINDOW_SIZE && nextSeqNum <= totalFrames) {
                    System.out.println("Sending frame: " + nextSeqNum);
                    out.println(nextSeqNum); // send frame as sequence number
                    nextSeqNum++;
                }

                // Wait for ACK with timeout
                socket.setSoTimeout(5000);
                try {
                    String ackStr = in.readLine();

                    if (ackStr != null && ackStr.startsWith("ACK ")) {
                        int ackNum = Integer.parseInt(ackStr.substring(4));
                        System.out.println("Received cumulative ACK: " + ackNum);

                        if (ackNum >= base) {
                            // Slide window forward
                            base = ackNum + 1;
                        }
                    }

                } catch (SocketTimeoutException e) {
                    // Timeout occurred → retransmit from base
                    System.out.println("Timeout! Retransmitting frames from: " + base);
                    nextSeqNum = base;
                }
            }

            // Indicate end of transmission
            out.println("END");
            System.out.println("All frames sent and acknowledged. Transmission complete.");

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
