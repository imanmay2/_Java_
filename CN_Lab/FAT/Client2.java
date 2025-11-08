import java.util.*;
import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String args[]) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // object for sending the input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str="";
            while (!(str.equals("end"))) {
                str = sc.nextLine();
                System.out.println("Sending to the server -> " + str);
                out.println(str);

                // receiving from the server.
                String s = in.readLine();

                System.out.println("Recieved from server : " + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}