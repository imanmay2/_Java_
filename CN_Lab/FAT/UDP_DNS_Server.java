import java.net.*;
import java.util.*;

public class UDP_DNS_Server {
    public static void main(String args[]){
        try{
            DatagramSocket socket=new DatagramSocket(5000);
            System.out.println("Waiting for client's msg..");
            
            DatagramPacket rp=new DatagramPacket(new byte[1024],1024);
            socket.receive(rp);
            
            String str=new String(rp.getData(),0,rp.getLength());


            InetAddress address=InetAddress.getByName(str);
            String s=address.getHostAddress();
            DatagramPacket sp=new DatagramPacket(s.getBytes(),s.length(),rp.getAddress(),rp.getPort());
            socket.send(sp);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
