import java.util.*;
import java.io.*;
import java.net.*;

public class Client3{
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",8004)){
            System.out.println("Welcome to the client server program");

            System.out.println("Enter the number : ");

            Scanner sc=new Scanner(System.in);
            String str=sc.next();

            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(str);

            String s=in.readLine();
            System.out.println(s);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}