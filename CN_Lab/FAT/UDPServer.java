import java.util.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) {

        try {
            DatagramSocket socket = new DatagramSocket(5000);
            System.out.println("Waiting for client");
            while (true) {
                DatagramPacket rp = new DatagramPacket(new byte[1024], 1024);
                socket.receive(rp);

                String str = new String(rp.getData(), 0, rp.getLength());
                System.out.println("Client : " + rp.getAddress() + "Port : " + rp.getPort() + "Data recieved : " + str);

                // server sending
                String s = str.toUpperCase();
                DatagramPacket sp = new DatagramPacket(s.getBytes(), s.length(), rp.getAddress(), rp.getPort());
                socket.send(sp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}