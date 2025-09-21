import java.util.*;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter the number of frames to send: ");
            int totalFrames = scanner.nextInt();

            System.out.print("Enter the window size: ");
            int windowSize = scanner.nextInt();

            boolean[] acked = new boolean[totalFrames + 1];
            int base = 1;
            int nextSeq = 1;

            while (base <= totalFrames) {
                while (nextSeq < base + windowSize && nextSeq <= totalFrames) {
                    System.out.println("Sending frame: " + nextSeq);
                    out.println(nextSeq);
                    nextSeq++;
                }

                String ack = in.readLine();
                if (ack != null) {
                    int ackNum = Integer.parseInt(ack);
                    System.out.println("Received ACK: " + ackNum);
                    acked[ackNum] = true;

                    while (base <= totalFrames && acked[base]) {
                        base++;
                    }
                }
            }

            out.println("END");
            System.out.println("All frames sent and acknowledged successfully.");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
