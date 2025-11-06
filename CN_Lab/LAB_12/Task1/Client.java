import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();

        String message = "Hello UDP Packet!";
        byte[] sendData = message.getBytes();

        InetAddress serverAddress = InetAddress.getLocalHost();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9100);

        clientSocket.send(sendPacket);
        System.out.println("Message sent to server.");

        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

        clientSocket.receive(receivePacket);

        String serverReply = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server reply (packet details): " + serverReply);

        clientSocket.close();
        System.out.println("Client closed.");
    }
}
