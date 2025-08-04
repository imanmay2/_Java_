import java.io.*;
import java.net.*;
public class client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public client(String address,int port){
        try{
            socket=new Socket(address,port);
            System.out.println("Client Connected...");
            input =new DataInputStream(System.in);  
            output=new DataOutputStream(socket.getOutputStream()); 
        } catch(UnknownHostException u){
            System.out.println(u);
            return;
        } catch(IOException i){
            System.out.println(i);
            return;
        }

        String line=new String(); //creates a empty String.
        while(!line.equals("end")){
            try{
                line=input.readLine(); // accepts data from the keyboard.
                output.writeUTF(line); // sends the data to the Server.
            } catch(UnknownHostException u){
                System.out.println(u);
                return;
            } catch(IOException i){
                System.out.println(i);
                return;
            }
        }
            try{
                input.close();
                output.close();
                socket.close();
            } catch(IOException i){
                System.out.println(i);
                return;
            }
    }
    public static void main(String args[]) {
        client cli=new client("127.0.0.1",5001);
    }
}
