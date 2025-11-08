import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Waiting for the client to connect..");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected .");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            //accepting the data from the client.
            String str=in.readLine();
            System.out.println("Received from the client : "+str);

            System.out.println("Length send back to the client.");
            out.println(Integer.toString(str.length()));

            socket.close();
            System.out.println("Connection closed.");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
