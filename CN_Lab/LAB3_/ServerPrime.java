import java.util.*;
import java.net.*;
import java.io.*;


public class ServerPrime {

    public static boolean checkPrime(int n){
        int ct=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                ct++;
            }
        } if(ct==2){
            return true;
        } else 
        return false;
    }
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5001)){
            System.out.println("Server Connected...");
            System.out.println("Waiting for client...");
            Socket socket=serverSocket.accept();
            System.out.println("Client Connected.");

            // getting data from the client.
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // sending back the response.
            // PrintWriter out=new PrintWriter(socket.getOutputStream());

            String str=in.readLine();
            int num=Integer.parseInt(str);
            if(checkPrime(num)){
                System.out.println(num+" is a prime number.");
            } else {
                System.out.println(num+" is not Prime.");
            }
        } catch(IOException i){
            System.out.println(i);
        }
    }
}
