import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args){
        try (Socket socket = new Socket("localhost", 5009)){
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
            boolean frame2Lost = true;

            while (base <= totalFrames) {
                while (nextSeq < base + windowSize && nextSeq <= totalFrames) {
                    if (nextSeq == 2 && frame2Lost) {
                        System.out.println("Frame 2 lost (not sent).");
                        frame2Lost = false;
                        nextSeq++;
                        continue;
                    }
                    System.out.println("Sending frame: " + nextSeq);
                    out.println(nextSeq);
                    nextSeq++;
                }

                socket.setSoTimeout(3000);
                try {
                    String ack = in.readLine();
                    if (ack != null) {
                        int ackNum = Integer.parseInt(ack);
                        System.out.println("Received ACK: " + ackNum);
                        acked[ackNum] = true;
                        while (base <= totalFrames && acked[base]) {
                            base++;
                        }
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout! Resending frame: " + base);
                    out.println(base);
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