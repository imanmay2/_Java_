import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Backendserver {
    private final int port;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public Backendserver(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Backend Server running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(() -> handleClient(clientSocket));
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Backend(" + port + ") received: " + line);
                out.println("Response from backend " + port + ": " + line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("Client disconnected from backend " + port);
        } finally {
            try { clientSocket.close(); } catch (IOException ignored) {}
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Backendserver <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new Backendserver(port).start();
    }
}
