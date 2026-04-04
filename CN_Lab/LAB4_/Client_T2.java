// Develop a client server program using odd parity scheme in which client 
// sends a data word as a code word  and server receives the same. Then it checks whether there is an error in received data. 
// If it is an error it discards the data and informs the same to the client else display the data in server side.

import java.io.*;
import java.util.*;
import java.net.*;

public class Client_T2{
    public static String addParity(String str){
        StringBuffer sb=new StringBuffer(str);
        int ct=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                ct++;
            }
        }
        return (ct%2!=0)?(sb.append('0').toString()):(sb.append('1').toString());
    }
    public static void main(String args[]){
        try(Socket socket=new Socket("127.0.0.1",5001)){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the DataWord (in binary): ");
            String str=sc.nextLine();
            PrintWriter out=new PrintWriter(socket.getOutputStream()); //obj for sending data to server.
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream())); //obj for accepting data from the server.
            out.println(addParity(str)); //sends the dataword to Server.
            out.flush();
            String data=in.readLine();
            System.out.println(data);
        } catch(IOException i){
            System.out.println(i);
        }
    }
}