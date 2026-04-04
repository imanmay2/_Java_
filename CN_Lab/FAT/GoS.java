import java.util.*;
import java.net.*;
import java.io.*;


public class GoS {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(9006)){
            System.out.println("Waiting for the client to join.");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected...");
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            int expSeq=0;

            ArrayList<String> list=new ArrayList<>();
            while(true){
                String msg=in.readLine();
                if(msg==null){
                    break;
                }

                if(expSeq==Integer.parseInt(msg.split(":")[0])){
                    System.out.println("Correct seq received : "+msg.split(":")[0]);
                    list.add(msg.split(":")[1]);
                    out.println(expSeq+":"+msg.split(":")[0]);
                    expSeq++;
                }else{
                    System.out.println("Received out of Order . Ignored");
                    out.pritln("NO");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}