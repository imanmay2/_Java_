import java.io.*;
import java.net.*;

public class Server {
    // Reg: 24BAI1316 , Manmay Chakraborty
    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Server started and waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // To read string from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // To send response to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read string from client
            String clientString = in.readLine();
            System.out.println("Received from client: " + clientString);

            // Calculate length
            int length = clientString.length();

            // Send length back to client
            out.println(length);
            System.out.println("Sent length to client: " + length);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}