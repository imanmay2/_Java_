import java.util.*;
import java.io.*;
import java.net.*;

public class Client9 {
    public static void main(String args[]) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // object for sending the input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(()->{
                try{
                    String s=in.readLine();
                    System.out.println("Received from server :"+s);

                } catch(Exception e){}
            }).start();

            String str=sc.nextLine();
            out.println(str);
            System.out.println("Sent to Server : "+str);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}