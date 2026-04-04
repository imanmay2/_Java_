import java.util.*;
import java.io.*;
import java.net.*;

public class Server4{

    public static boolean check(String str){
        int ct=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                ct++;
            }
        }if(ct%2==0){
            return true; //even parity

        }

        return false; //odd parity
    }
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(3005)){
            System.out.println("Client yet to be connected .. ");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected..");
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            String str=in.readLine();
            boolean check=check("10011");
            if(check){
                out.println("Data received succesfully.");
                System.out.println("Data Received : "+str);
            }else{
                out.println("Data is having some error.");
            }

            socket.close();
            System.out.println("Program terminated.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}