// Develop a client server program in which client sends a number and 
// server receives the same. Server checks whether prime or not and display the same in server.


import java.util.*;
import java.net.*;
import java.io.*;

public class ClientPrime {
    public static void main(String args[]){
        try(Socket socket=new Socket("127.0.0.1",5001)){
        Scanner sc=new Scanner(System.in);

        PrintWriter out=new PrintWriter(socket.getOutputStream()); //initializing object for sending data to server.

        // BufferedReader in=new BufferedReader(new InputStreamReader((socket.getInputStream()))); //initializing object for getting data from client.

        int num=sc.nextInt();

        System.out.println("Sent "+num+" to Server.");

        out.println(num);  //send data to server.
    } catch(IOException i){
        System.out.println(i);
    }
    }
}
