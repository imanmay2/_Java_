
import java.util.*;
import java.io.*;
import java.net.*;
public class server {
    private ServerSocket server=null;
    private Socket socket=null;
    private DataInputStream input=null;

    public server(int port){
        try{
            server =new ServerSocket(port);
            System.out.println("Server is connected...");
            System.out.println("Waiting for the client...");
            socket=server.accept();
            System.out.println("Client is connected.");
            input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));


            String line="";

            while(!line.equals("end")){
                try{
                    line=input.readUTF();
                    System.out.println(line);
                } catch(IOException i){
                    System.out.println(i);
                    return;
                }
            }

            System.out.println("Closing connection");
            
            socket.close();
            input.close();
        } catch(IOException i){
            System.out.println(i);
            return;
        }
    }
    public static void main(String args[]){
        server s=new server(5001);
    }
}
