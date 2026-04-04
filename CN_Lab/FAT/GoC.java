import java.util.*;
import java.net.*;
import java.io.*;

public class GoC {
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",9006)){
            Scanner sc=new Scanner(System.in);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            int base=0;
            int next=0;
            int ws=3;
            String msg[]={"Hello","Welcome","How","are","you"};
            boolean ackR[]=new boolean[msg.length];
            while(base<msg.length){
                while(next<base+ws && next<msg.length){
                    //sending messages to the client.
                    
                    System.out.println("Sending Frame : "+next+"Data : "+msg[next]);
                    if(next==2){
                        continue;
                    }
                    out.println(next+":"+msg[next]);
                    next++;
                }

                //receiving the ack from the server.
                for(int i=base;i<next;i++){
                    String s=in.readLine();
                    System.out.println("Received from server : "+s.split(":")[1]);
                    ackR[Integer.parseInt(s.split(":")[0])]=true;
                }

                while(base<next && ackR[base]){
                    base++;
                }

                if(next<base+ws){
                    base=next;
                }
            }
            System.out.println("All datapackets are received correctly.");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
