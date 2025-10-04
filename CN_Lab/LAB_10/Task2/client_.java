import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client_ {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5009);
        System.out.println("Connected to server...");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        String ip;
        while (true) {
            System.out.print("Enter IP address (or 'exit' to quit): ");
            ip = scanner.nextLine();
            out.println(ip);

            if (ip.equalsIgnoreCase("exit")) break;

            String response = in.readLine();
            System.out.println("Server says: " + response);
        }

        socket.close();
        scanner.close();
    }
}
