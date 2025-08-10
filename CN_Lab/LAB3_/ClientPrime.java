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
        int num=0;
        while(num>=0){
            System.out.println("Enter the number : ");
            num=sc.nextInt();
            String str=Integer.toString(num);
            out.println(str); //data sending to the server.
            out.flush();
            System.out.println("Sent "+num+" to Server.");
            // num=Integer.parseInt(num);
        }

        System.out.println("Terminating from the client side...");
        socket.close();
        sc.close();
        System.out.println("Connection closed from the client side.");
    } catch(IOException i){
        System.out.println(i);
    }
    }
}
