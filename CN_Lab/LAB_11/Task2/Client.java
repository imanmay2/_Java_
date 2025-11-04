import java.net.*;
import java.io.*;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        try (
            DatagramSocket clientSocket = new DatagramSocket();
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            System.out.println("Connected to UDP Server at " + SERVER_HOST + ":" + SERVER_PORT);
            System.out.println("Type your message below (type 'exit' to quit):");

            while (true) {
                System.out.print("> ");
                String message = userInput.readLine();

                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Exiting client...");
                    break;
                }

                sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String serverReply = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server reply: " + serverReply);
            }

        } catch (IOException e) {
            System.err.println("Error in UDP Client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
