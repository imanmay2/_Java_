import java.io.*;
import java.net.*;

public class Client {
    private static Socket socket;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;

    public static void main(String[] args) throws IOException {
        // Extract the arguments from command line arguments
        String num1 = args[0];
        String num2 = args[1];
        String operator = args[2];
        // Create a new socket and attempt to connect to the server
        socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 5001), 1000);
        System.out.println("Connection Successful!");
        // Initialize input and output streams for communication with the server
        dataIn = new DataInputStream(socket.getInputStream());
        dataOut = new DataOutputStream(socket.getOutputStream());
        // Send calculation details to the server
        dataOut.writeUTF(num1);
        dataOut.writeUTF(num2);
        dataOut.writeUTF(operator);
        // Receive and print the server's response
        String serverMessage = dataIn.readUTF();
        System.out.println("Result: " + serverMessage);
    }
}