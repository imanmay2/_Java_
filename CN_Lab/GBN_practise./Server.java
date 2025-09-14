import java.util.*;
import java.net.*;
import java.io.*;

public class Server{
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(8080)){
            System.out.println("Server Connected");
            Socket socket=serverSocket.accept();
            System.out.println("Client Connected.");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            int expectedFrame=0;
            //fetch data from client
            String str=in.readLine();
            while(!str.equals("END")){
                String str_[]=str.split(":");
                if(Integer.parseInt(str_[1])==expectedFrame){
                    System.out.println("Data Received : "+str_[1]);
                    out.println(String.valueOf(str_[1]));
                    expectedFrame++;
                }else{
                    System.out.println("Wrong Frame Received : "+str_[1]);
                    out.println(String.valueOf(expectedFrame-1));
                }
                str=in.readLine();
            }

            socket.close();
            serverSocket.close();
            System.out.println("Closing Connection.");
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}