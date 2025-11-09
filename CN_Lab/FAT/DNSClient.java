import java.net.*;
import java.io.*;
import java.util.*;


public class DNSClient {

    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",8005)){
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            

            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine(); //enter the domain

            out.println(str);

            String s=in.readLine();
            System.out.println("Response from server : "+s);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
