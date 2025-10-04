import java.io.*;
import java.net.*;

public class server_24BAI1316 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5009);
        System.out.println("Server ready... Waiting for client...");

        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String frame;
        while ((frame = in.readLine()) != null) {
            System.out.println("Received Frame: " + frame);
            
           
            out.println("ACK");
            System.out.println("Sent ACK for: " + frame);

            if (frame.equals("end")) break;
        }

        socket.close();
        serverSocket.close();
    }
}
