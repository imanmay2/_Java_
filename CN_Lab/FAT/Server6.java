import java.util.*;
import java.net.*;
import java.io.*;

public class Server6 {
    public static void main(String args[]) {
        try (ServerSocket serverSocket = new ServerSocket(7005)) {
            System.out.println("Waiting for the client ...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected. ");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String str = in.readLine();
            str = str.replace("[", "").replace("]", "").trim();
            String arr[] = str.split(",");
            // changing the flipping the second last bit.
            StringBuilder sb = new StringBuilder(arr[arr.length - 1]);

            if (sb.charAt(6) == '0') {
                sb.setCharAt(6, '1');
            } else {
                sb.setCharAt(6, '0');
            }

            arr[arr.length - 1] = sb.toString(); // update the array
            

            System.out.println("Recieved from client: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

            out.println("Data recieved .. ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
