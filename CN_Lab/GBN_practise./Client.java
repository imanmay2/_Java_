import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",8080)){
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Client Connected.");
            Scanner sc=new Scanner(System.in);

            //input
            System.out.println("Enter the String : ");
            String str=sc.next();

            for(int i=0;i<str.length();i++){

                //send data to the server.
                out.println(str.charAt(i)+":"+String.valueOf(i));
                System.out.println("Sending Frame: "+i+" Data : "+str.charAt(i));

                //waiting for the acknowledgement.
                String ack=in.readLine();
                System.out.println("Received Ack : "+ack);
            }

            out.println("END");
            socket.close();
            System.out.println("Connection Closed.");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}