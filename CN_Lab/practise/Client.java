import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",5009)){
            Scanner sc=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream());  //sending data to the Server.
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));   // fetching data from the server.

            System.out.println("Enter the Number to be send: ");
            String str=sc.nextLine();
            out.println(str);
            out.flush();
            System.out.println("Number send to the server : "+str);

            String strRes=in.readLine(); // data from server.
            
            if(strRes.equals("True")){
                System.out.println(str+" is a prime number.");
            } else{
                System.out.println(str+" is not a prime number.");
            }

            socket.close();
            System.out.println("Connection Closed.");

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
