import java.io.*;
import java.net.*;


public class client {
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream output=null;
    private DataInputStream inputFromServer=null;
    public client(String address,int port){
        try{
            socket=new Socket(address,port);
            System.out.println("Client Connected...");
            input=new DataInputStream(System.in);
            output=new DataOutputStream(socket.getOutputStream()); //sending data to the client.
            inputFromServer=new DataInputStream(new BufferedInputStream((socket.getInputStream())));
        } catch(UnknownHostException u){
            System.out.println(u);
            return;
        } catch(IOException i){
            System.out.println(i);
            return;
        }

        String line=new String();
        while(!line.equals("end")){
            try{
                line=input.readLine();
                output.writeUTF(line); //sending data to the server/backend.
                output.flush(); // ensures the data is going immediately from client to server.

                String response=inputFromServer.readUTF();
                

                System.out.println("Length of the String is: "+response);
            } catch(IOException i){
                System.out.println(i);
                return;
            }
        }

        System.out.println("Closing the Connection.");
        input.close();
        output.close();
        socket.close();
    }
    public static void main(String args[]){
        client cli=new client("127.0.0.1",5001);
    }
}
