import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_T2{

    public static boolean parityCheck(String str){ 
        int ct=0;
        StringBuffer sb=new StringBuffer(str);
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='1'){
                ct++;
            }
        }
        return (ct%2!=0);
    }
    public static void main(String args[]){
        try(ServerSocket server=new ServerSocket(5001)){
            System.out.println("Server Started.");
            Socket socket=server.accept();
            System.out.println("Client Connected...");

            PrintWriter out=new PrintWriter(socket.getOutputStream());

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str=in.readLine();
            if(parityCheck(str)){
                System.out.println("DataWord Accepted.");
                System.out.println("No Error found.");
            } else{
                out.println("Error found in DataWord !! Please Try Again!");
                out.flush();
            }
        } catch(IOException i){
            System.out.println(i);
        }
    }
}