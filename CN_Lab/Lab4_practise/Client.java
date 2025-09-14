import java.util.*;
import java.net.*;
import java.nio.Buffer;
import java.io.*;

public class Client {

    //even parity
    public static StringBuilder genCodeWord(StringBuilder str){
        int ct=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                ct++;
            }
        } if(ct%2!=0){
            str.append('1');
        } else{
            str.append('0');
        } return str;

    }
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",5008)){
            System.out.println("Client Connected.");
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the dataword in binary (100101): ");
            String data=sc.next(); //dataword
            StringBuilder sb=new StringBuilder(data);
            //codeword
            StringBuilder codeword=genCodeWord(sb);
            System.out.println("Code word generated : "+codeword);
            out.println(codeword);//sending codeword to client.
            out.flush();
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream())); // accept the ack from server.
            String str__=in.readLine();
            System.out.println(str__);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
