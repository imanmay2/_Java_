import java.util.*;
import java.net.*;

public class Server10 {
    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            System.out.println("Waitng for the client...");

            while (true) {

                DatagramPacket rp = new DatagramPacket(new byte[1024], 1024);
                socket.receive(rp);

                new Thread(() -> {
                    try {
                        String str = new String(rp.getData(), 0, rp.getLength());
                        System.out.println(
                                "Client IP : " + rp.getAddress() + " port : " + rp.getPort() + " Data : " + str);

                        // sending response to the client.
                        String s = "MSG Received. " + str;
                        DatagramPacket sp = new DatagramPacket(s.getBytes(), s.length(), rp.getAddress(), rp.getPort());
                        socket.send(sp);
                    } catch (Exception e) {
                        System.out.println("Client disconnected.");
                    }
                }).start();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}