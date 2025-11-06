import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter service name (prime/even_odd): ");
        String service = sc.nextLine();

        String data = number + "," + service;
        InetAddress ip = InetAddress.getLocalHost();

        DatagramPacket sendPacket = new DatagramPacket(data.getBytes(), data.length(), ip, 9100);
        clientSocket.send(sendPacket);

        byte[] buf = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
        clientSocket.receive(receivePacket);

        String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server reply: " + reply);

        clientSocket.close();
        sc.close();
    }
}
