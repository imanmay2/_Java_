import java.io.*;
import java.net.*;
import java.util.*;

public class LoadBalancer {
    private static List<InetSocketAddress> backendServers = new ArrayList<>();
    private static int currentServerIndex = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Load Balancer started on port 8000");

        backendServers.add(new InetSocketAddress("localhost", 9001));
        backendServers.add(new InetSocketAddress("localhost", 9002));

        while (true) {
            Socket clientSocket = serverSocket.accept();
            InetSocketAddress backend = getNextServer();
            forwardRequest(clientSocket, backend);
        }
    }

    private static InetSocketAddress getNextServer() {
        InetSocketAddress server = backendServers.get(currentServerIndex);
        currentServerIndex = (currentServerIndex + 1) % backendServers.size();
        return server;
    }

    private static void forwardRequest(Socket clientSocket, InetSocketAddress backend) {
        try {
            Socket backendSocket = new Socket(backend.getHostName(), backend.getPort());
            System.out.println("Forwarding request to " + backend);
            Thread clientToBackend = new Thread(() -> forward(clientSocket, backendSocket));
            Thread backendToClient = new Thread(() -> forward(backendSocket, clientSocket));

            clientToBackend.start();
            backendToClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void forward(Socket from, Socket to) {
    try {
        InputStream in = from.getInputStream();
        OutputStream out = to.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
            out.flush();
        }

    } catch (IOException e) {
        System.err.println("Data forwarding error: " + e.getMessage());
    } finally {
        try { from.close(); } catch (IOException ignored) {}
        try { to.close(); } catch (IOException ignored) {}
    }
}
}
