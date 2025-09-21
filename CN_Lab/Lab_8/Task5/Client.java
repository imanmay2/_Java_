import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner scanner = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            socket.setSoTimeout(3000);
            System.out.print("Enter the number of frames to send: ");
            int totalFrames = scanner.nextInt();
            for (int i = 0; i < totalFrames; i++) {
                boolean ackReceived = false;
                while (!ackReceived) {
                    System.out.println("Sending frame: " + i);
                    out.println(i);
                    try {
                        String ack = in.readLine();
                        if (ack != null && Integer.parseInt(ack) == i + 1) {
                            System.out.println("Received ACK: " + ack);
                            ackReceived = true;
                        }
                    } catch (SocketTimeoutException e) {
                        System.out.println("Timeout for frame " + i + ", resending...");
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
