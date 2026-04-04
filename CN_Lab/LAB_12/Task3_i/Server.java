import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9400);
        System.out.println("TCP DNS Server is running on port 9400...");

        while (true) {
            Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String host = reader.readLine();
            System.out.println("Received domain query: " + host);
            String ipAddress;
            try {
                InetAddress ip = InetAddress.getByName(host);
                ipAddress = ip.getHostAddress();
            } catch (Exception e) {
                ipAddress = "Host not found";
            }

            writer.println(ipAddress);
            System.out.println("Sent IP address: " + ipAddress + "\n");

            reader.close();
            writer.close();
            socket.close();
        }
    }
}
