import java.util.*;
import java.net.*;
import java.io.*;

public class ServerArmstrong {
    public static boolean checkArmStrong(int n){
        int num=n;
        int s=0;
        while(n!=0){
            int r=n%10;
            s+=Math.pow(r,3);
            n=n/10;
        }
        return (s==num)?true:false;
    }
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5001)){
            System.out.println("Server Connected.");
            System.out.println("Waiting for Client...");
            Socket socket=serverSocket.accept();
            System.out.println("Client Connected.");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream())); //reading from the client.

            PrintWriter out=new PrintWriter(socket.getOutputStream()); //sending response to the server.

            int num=0;
            while(num>=0){
                String str=in.readLine();
                if(str==null) {
                    break;
                }
                
                num=Integer.parseInt(str);

                System.out.println("Number received from client: "+num);
                if(checkArmStrong(num)){
                    out.println(Integer.toString(num)+" is a Armstrong number.");
                    out.flush();
                } else{
                    out.println(Integer.toString(num)+" is not an Armstrong number.");
                    out.flush();
                }
            }

            System.out.println("Terminating...");
            socket.close();
            System.out.println("Connection closed from Server Side.");


        }catch(IOException i){
            System.out.println(i);
        }
    }
}
