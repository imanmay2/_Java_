import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9000);
        System.out.println("UDP DNS Server is running on port 9000...");

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);
            String hostName = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received query for host: " + hostName);
            String ipAddress;
            try {
                InetAddress ip = InetAddress.getByName(hostName);
                ipAddress = ip.getHostAddress();
            } catch (Exception e) {
                ipAddress = "Host not found";
            }
            byte[] replyData = ipAddress.getBytes();
            DatagramPacket replyPacket = new DatagramPacket(
                replyData,
                replyData.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
            );
            serverSocket.send(replyPacket);
            System.out.println("Sent IP address: " + ipAddress + "\n");
        }
    }
}
