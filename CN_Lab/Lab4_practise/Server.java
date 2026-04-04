import java.util.*;
import java.net.*;
import java.io.*;

public class Server {

    //check the even parity upto n-1 character
    public static boolean checkEvenParity(StringBuilder str){
        int ct=0;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)=='1'){
                ct++;
            }
        }

        if(ct%2==0 && str.charAt(str.length()-1)=='0'){
            return true;
        } else if(ct%2!=0 && str.charAt(str.length()-1)=='1'){
            return true;
        } return false;
    }
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5008)){

            System.out.println("Server Connected.");
            System.out.println("Waiting for the Client...");
            Socket socket=serverSocket.accept();
            System.out.println("Client Connected.");
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str=in.readLine();
            StringBuilder sb=new StringBuilder(str);


            //check 
            boolean flag=checkEvenParity(sb);

            PrintWriter out=new PrintWriter(socket.getOutputStream());
            if(flag==false){
                
                out.println("Error in the data");
                out.flush();
                
            }else {
                System.out.println("No error in the data received : "+sb);
                out.println("Data received successfully.");
                out.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        } 
    }
}
