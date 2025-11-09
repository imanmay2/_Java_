import java.net.*;

import java.util.*;

public class UDPClient{
    public static void main(String args[]){
        try{
            DatagramSocket socket=new DatagramSocket();
            InetAddress ip=InetAddress.getByName("localhost");

            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();

            DatagramPacket sp=new DatagramPacket(str.getBytes(),str.length(),ip,5000);
            socket.send(sp);

            //server message
            DatagramPacket rp=new DatagramPacket(new byte[1024],1024);
            socket.receive(rp);

            String s=new String(rp.getData(),0,rp.getLength());

            System.out.println("Server : "+s);


            socket.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}