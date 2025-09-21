import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        final int PORT = 5009;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client on port " + PORT + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String receivedFrame;
            while ((receivedFrame = in.readLine()) != null) {
                if (receivedFrame.equalsIgnoreCase("END")) {
                    break;
                }
                try {
                    int frameNumber = Integer.parseInt(receivedFrame);
                    System.out.println("Received Frame: " + frameNumber);
                    out.println(frameNumber);
                    System.out.println("Sent ACK: " + frameNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid frame received: " + receivedFrame);
                }
            }

            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
