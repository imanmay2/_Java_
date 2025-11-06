import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getLocalHost();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter domain name: ");
        String domain = sc.nextLine();

        byte[] queryData = domain.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(queryData, queryData.length, serverAddress, 9000);
        clientSocket.send(sendPacket);
        System.out.println("Query sent to DNS server.");

        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        clientSocket.receive(receivePacket);

        String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("DNS Server Reply: " + reply);

        clientSocket.close();
        sc.close();
    }
}
