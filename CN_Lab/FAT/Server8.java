import java.util.*;
import java.io.*;
import java.net.*;

public class Server8 {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Waiting for the client to connect..");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected .");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            //accepting the data from the client.
            String str="";
            
            while((str=in.readLine())!=null){
                System.out.println("Received from the client : "+str);


                try{
                    Thread.sleep(2000);
                } catch(InterruptedException e){
                    // System.out.println("Interrupted.");
                }


                out.println("ACK");
                System.out.println("Ack sent.");
            }

            
            

            socket.close();
            System.out.println("Connection closed.");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
