import java.io.*;
import java.net.*;

public class Backendserver {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Backendserver <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Backend server running on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Backend(" + port + ") received: " + line);
                out.println("Response from backend " + port + ": " + line.toUpperCase());
            }
            socket.close();
        }
    }
}
