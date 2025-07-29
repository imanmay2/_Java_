//Develop a client - server program to transfer the text message from client to server  and display the same along with string length as a message in client side using Java


import java.net.*;
import java.io.*;

public class server {
    private ServerSocket server=null;
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream outFromServer=null;
    public server(int port){
        try{
            server=new ServerSocket(port);
            System.out.println("Server Connected...");
            System.out.println("Waiting for the client");

            socket=server.accept();

            System.out.println("Client Connected.");

            input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            outFromServer=new DataOutputStream(socket.getOutputStream());
            String line=new String();

            while(!line.equals("end")){
                try{
                    line=input.readUTF();  // basically it reads the data from the client side.
                    System.out.println(line);
                    outFromServer.writeUTF(String.valueOf(line.length())); // sends back the data from server to client
                    outFromServer.flush(); // ensures data is immediately send from server to client.

                } catch(IOException i){
                    System.out.println(i);
                    return;
                }
            }

            System.out.println("Closing Connection");
            input.close();
            socket.close();
        } catch(IOException i){
            System.out.println(i);
            return;
        }
    }
    public static void main(String args[]){
        server s=new server(5001);
    }
}
