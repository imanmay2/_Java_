import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Create a DatagramSocket for sending packets
        DatagramSocket socket = new DatagramSocket();

        // Get the IP address of the local host (can be replaced with server IP)
        InetAddress serverIP = InetAddress.getLocalHost();

        System.out.println("UDP Client started...");
        System.out.println("Type your message (type 'bye' to exit):");

        while (true) {
            // Read user input
            String input = scanner.nextLine();

            // Convert the input string to bytes
            byte[] buffer = input.getBytes();

            // Create a packet to send data to server on port 7234
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverIP, 7234);

            // Send the packet
            socket.send(packet);

            // Exit condition
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Exiting client...");
                break;
            }
        }

        // Close the socket
        socket.close();
        scanner.close();
    }
}
