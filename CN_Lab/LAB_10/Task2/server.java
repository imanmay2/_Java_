import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5009);
        System.out.println("Server started. Waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);

            // handle each client in a separate thread
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String ip;
            while ((ip = in.readLine()) != null) {
                if (ip.equalsIgnoreCase("exit")) {
                    out.println("Connection closed.");
                    break;
                }
                System.out.println("Received from client: " + ip);
                String response = getIPClass(ip);
                out.println(response);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getIPClass(String ip) {
        try {
            String[] parts = ip.split("\\.");
            int firstOctet = Integer.parseInt(parts[0]);

            if (firstOctet >= 1 && firstOctet <= 126) return "Class A";
            else if (firstOctet >= 128 && firstOctet <= 191) return "Class B";
            else if (firstOctet >= 192 && firstOctet <= 223) return "Class C";
            else if (firstOctet >= 224 && firstOctet <= 239) return "Class D (Multicast)";
            else if (firstOctet >= 240 && firstOctet <= 255) return "Class E (Experimental)";
            else return "Invalid IP";
        } catch (Exception e) {
            return "Invalid IP format!";
        }
    }
}
