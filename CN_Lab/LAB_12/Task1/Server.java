import java.net.*;

public class Server{
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9100);
        System.out.println("Server is running and waiting for client message...");

        byte[] buffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(receivePacket);

        String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

        String clientInfo = "From: " + receivePacket.getAddress() + ":" + receivePacket.getPort() +
                            " | Length: " + receivePacket.getLength() +
                            " | Content: " + receivedMessage;

        System.out.println("Server received: " + clientInfo);

        byte[] replyData = clientInfo.getBytes();
        DatagramPacket replyPacket = new DatagramPacket(
            replyData, replyData.length, receivePacket.getAddress(), receivePacket.getPort()
        );

        serverSocket.send(replyPacket);

        serverSocket.close();
        System.out.println("Server closed.");
    }
}
