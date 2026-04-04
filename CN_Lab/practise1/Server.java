import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Server Connected.");
            System.out.println("Waiting for Client...");
            Socket socket=serverSocket.accept();
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str=in.readLine();

            System.out.println("Received from client : ");
            while(!str.equalsIgnoreCase("end")){
                System.out.println(str);
                str=in.readLine();
            }

            //closing connection.
            socket.close();
            System.out.println("Closing Connection.");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}