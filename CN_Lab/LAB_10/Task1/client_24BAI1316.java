import java.io.*;
import java.net.*;

public class client_24BAI1316{
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5009);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = "hello Manmay Reg:24BAI1316";
        String[] words = message.split(" ");

        for (String word : words) {
            boolean ackReceived = false;

            while (!ackReceived) {
                System.out.println("Sending Frame: " + word);
                out.println(word);

                String ack = in.readLine();
                if (ack != null && ack.equals("ACK")) {
                    System.out.println("Received ACK for: " + word);
                    ackReceived = true;
                } else {
                    System.out.println("ACK not received. Retransmitting...");
                }
            }
        }


        out.println("end");
        socket.close();
    }
}
