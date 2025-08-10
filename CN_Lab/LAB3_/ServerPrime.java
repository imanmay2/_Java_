import java.util.*;
import java.net.*;
import java.io.*;

public class ServerPrime {

    public static boolean checkPrime(int n) {
        int ct = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ct++;
            }
        }
        if (ct == 2) {
            return true;
        } else
            return false;
    }

    public static void main(String args[]) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Server Connected...");
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected.");

            // getting data from the client.
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int num = 0;
            while (num >= 0) {
                String str = in.readLine();
                num = Integer.parseInt(str);
                if (checkPrime(num)) {
                    System.out.println(num + " is a prime number.");
                } else {
                    System.out.println(num + " is not Prime.");
                }
            }
            System.out.println("Terminating...");
            serverSocket.close();
            socket.close();
            System.out.println("Connection Closed from the server side.");

        } catch (IOException i) {
            System.out.println(i);
        }
    }
}
