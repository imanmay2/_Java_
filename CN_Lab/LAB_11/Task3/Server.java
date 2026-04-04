import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        final int SERVER_PORT = 12345;

        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            System.out.println("UDP Server is running on port " + SERVER_PORT);

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from " + receivePacket.getAddress() + ":" + receivePacket.getPort() + " - " + receivedMessage);

                String responseMessage = "Server received: " + receivedMessage;
                byte[] sendBuffer = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
