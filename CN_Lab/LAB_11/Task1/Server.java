import java.io.*;
import java.net.*;

public class Server {

    // Converts byte array data to a readable string
    public static StringBuilder dataToString(byte[] data) {
        if (data == null) return null;

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < data.length && data[i] != 0) {
            result.append((char) data[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7234);
        byte[] buffer = new byte[65535];
        DatagramPacket packet;

        System.out.println("UDP Server is running...");

        while (true) {
            // Receive data from client
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String clientData = dataToString(buffer).toString();
            System.out.println("Client: " + clientData);

            // Exit condition
            if (clientData.equalsIgnoreCase("bye")) {
                System.out.println("Client sent 'bye'... Exiting.");
                break;
            }

            // Reset buffer for next message
            buffer = new byte[65535];
        }

        socket.close();
    }
}
