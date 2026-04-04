import java.util.*;
import java.net.*;
import java.io.*;


public class Client {
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",5009)){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the String : ");
            String str=sc.nextLine();
            

            while(!str.equalsIgnoreCase("end")){
                PrintWriter out=new PrintWriter(socket.getOutputStream());
                System.out.println("String send to Server : "+str);
                out.println(str); //data send to Server.
                out.flush();
                str=sc.nextLine();
            }

            //closing the connection.
            socket.close();
            System.out.println("Closing the connection.");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
