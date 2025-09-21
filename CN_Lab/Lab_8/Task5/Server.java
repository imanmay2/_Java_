import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5009)) {
            System.out.println("Server started, waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String frame;
            while ((frame = in.readLine()) != null) {
                if (frame.equals("END")) {
                    break;
                }

                int frameNum = Integer.parseInt(frame);
                System.out.println("Received Frame " + frameNum);

                int ackNum = frameNum + 1;
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
