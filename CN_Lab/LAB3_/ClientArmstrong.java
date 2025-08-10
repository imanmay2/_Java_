
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientArmstrong {
    public static void main(String args[]){
        try(Socket socket=new Socket("127.0.0.1",5001)){
            System.out.println("Client Connected");
            Scanner sc=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream()); 
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int num=0;

            while(num>=0){
                System.out.println("Enter the number : ");
                num=sc.nextInt();
                if(num<0){
                    break;
                }
                String str=Integer.toString(num);
                out.println(str);
                out.flush(); //ensures that my data has sent to the user.

                //fetching resposne from the server side.
                String str_=in.readLine();
                System.out.println(str_);
            }
            System.out.println("Terminating...");
            socket.close();
            sc.close();
            System.out.println("Connection closed from Client side.");
        } catch(IOException i){
            System.out.println(i);
        }
    }
}
