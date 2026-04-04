import java.util.*;
import java.io.*;
import java.net.*;

public class Client8 {
    public static void main(String args[]) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // object for sending the input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str_ = "Hello I love Anwesha Chakraborty.";

            String arr[] = str_.split(" ");
            for (String str : arr) {
                String ack;
                boolean flag=false;
                while (flag == false) {
                    System.out.println("Sending : " + str);
                    out.println(str);

                    ack = in.readLine();
                    if ("ACK".equals(ack)) {
                        System.out.println("ACK received successfully.");
                        flag=true;
                    }else{
                        System.out.println("Resending..");
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}