import java.net.*;
import java.io.*;

public class Server {

    // The port on which the server listens for incoming packets
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        byte[] receiveBuffer = new byte[1024];

        try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
            System.out.println(" UDP Server is running on port " + SERVER_PORT + "...");
            System.out.println("Waiting for clients to send data...\n");

            // Continuous loop to listen for incoming packets
            while (true) {
                // Receive packet from a client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);  // Blocking call — waits for client packet

                // Handle each client request in a new thread
                new Thread(() -> {
                    try {
                        // Extract client data and address details
                        String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        InetAddress clientAddress = receivePacket.getAddress();
                        int clientPort = receivePacket.getPort();

                        System.out.println(" Received from " + clientAddress.getHostAddress() + ":" + clientPort + " → " + clientMessage);

                        // Prepare response (convert message to uppercase for demo)
                        String responseMessage = "Server received: " + clientMessage.toUpperCase();
                        byte[] sendBuffer = responseMessage.getBytes();

                        // Send response back to the client
                        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                        serverSocket.send(sendPacket);

                        System.out.println(" Sent response to " + clientAddress.getHostAddress() + ":" + clientPort + "\n");
                    } catch (IOException e) {
                        System.err.println("Error handling client request: " + e.getMessage());
                    }
                }).start();
            }

        } catch (IOException e) {
            System.err.println(" Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
