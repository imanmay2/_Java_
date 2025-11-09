import java.util.*;
import java.io.*;
import java.net.*;


public class DNSServer {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(8005)){
            System.out.println("Waiting for the client to join..");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected...");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            String str=in.readLine();
            InetAddress address=InetAddress.getByName(str);
            out.println("IP Address is as follows : "+address.getHostAddress());


            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
