import java.util.*;
import java.net.*;
import java.io.*;

public class Server {

    public static boolean checkPrime(int n){
        int ct=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                ct++;
            }
        }

        if(ct==2){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Server is connected.");
            System.out.println("Waiting for Client...");
            Socket socket=serverSocket.accept();
            System.out.println("Client connected");
            //read data from the client.
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //send data to the client.
            PrintWriter out=new PrintWriter(socket.getOutputStream());

            String str=in.readLine();
            int num=Integer.parseInt(str);

            System.out.println("Number Received from the client : "+str);
            String dataS=checkPrime(num)?"True":"False";
            out.println(dataS);
            out.flush();

            socket.close();

            System.out.println("Connection Closed.");


        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
