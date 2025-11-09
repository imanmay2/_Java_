import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_DNS_Client {
    public static void main(String args[]){
        try{
            DatagramSocket socket=new DatagramSocket();
            
            InetAddress ip=InetAddress.getByName("localhost");

            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            

            DatagramPacket sp=new DatagramPacket(str.getBytes(),str.length(),ip,5000);
            socket.send(sp);


            //receive the address from the client.
            DatagramPacket rp=new DatagramPacket(new byte[1024],1024);
            socket.receive(rp);

            String s=new String(rp.getData(),0,rp.getLength());
            System.out.println("Server : "+s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
