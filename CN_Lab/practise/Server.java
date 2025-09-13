import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Server is connected.");
            System.out.println("Waiting for Client...");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected");
            //read data from the client.
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //send data to the client.
            PrintWriter out=new PrintWriter(socket.getOutputStream());

            String str=in.readLine();

            System.out.println("Received from the client : "+str);
            out.println("Length of the string calculated is : "+str.length());
            out.flush();

            socket.close();

            System.out.println("Connection Closed.");


        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
