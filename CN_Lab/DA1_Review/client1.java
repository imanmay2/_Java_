import java.io.*;
import java.net.*;
import java.util.*;

public class Client1 {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to LoadBalancer at " + host + ":" + port);
            System.out.println("Type a message to send. Type 'exit' to quit.\n");

            while (true) {
                System.out.print("Enter message: ");
                String msg = sc.nextLine();

                if (msg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                out.println(msg);

                String response = in.readLine();
                if (response == null) {
                    System.out.println("Server closed the connection.");
                    break;
                }

                System.out.println("Received from backend: " + response);
            }

        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
