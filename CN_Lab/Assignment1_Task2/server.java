import java.io.*;
import java.net.*;
public class server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    public server(int port){
        try{
            server=new ServerSocket(port);
            System.out.println("Server is connected.");
            System.out.println("Waiting for the client.");
            socket=server.accept();
            System.out.println("Client Accepted.");
            input=new DataInputStream(System.in); //takes input from the keyboard.
            out=new DataOutputStream(socket.getOutputStream());
        } catch(UnknownHostException u){
            System.out.println(u);
            return;
        } catch(IOException i){
            System.out.println(i);
            return;
        }
        String line="";
        while(!line.equals("End")){
            try{
                line=input.readLine();
                out.writeUTF(line); //sends data to the client.
            } catch(IOException i){
                System.out.println(i);
                return;
            }
        }
        System.out.println("Closing Connection.");
        try{
            input.close();
        out.close();
        socket.close();
        server.close();
        } catch(IOException i){
            System.out.println(i);
            return;
        }
    }
    public static void main(String args[]){
        server s=new server(5001);
    }
}
