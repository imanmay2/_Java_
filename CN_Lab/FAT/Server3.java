import java.util.*;
import java.io.*;
import java.net.*;

public class Server3 {
    public static boolean prime(int n) {
        int ct = 0;
        for (int i=1;i<=n;i++) {
            if (n % i == 0) {
                ct++;
            }
        }
        if (ct == 2) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        try (ServerSocket serverSocket = new ServerSocket(8004)) {
            System.out.println("Waiting for the client to join...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected..");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String str = in.readLine();
            try{
                int num = Integer.parseInt(str);
            boolean check = prime(num);
            if (check) {
                out.println(str + " is Prime");
            } else {
                out.println(str + " is not prime");
            }
            } catch(Exception e1){
                out.println("Enter a valid number.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}