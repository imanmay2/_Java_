import java.util.*;
import java.io.*;
import java.net.*;


public class Client4{

    public static String check(String str){
        StringBuilder sb=new StringBuilder("");
        int ct=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                ct++;
            }
            sb.append(str.charAt(i));
        }

        if(ct%2!=0){
            sb.append('1');
        }else{
            sb.append('0');
        }

        return sb.toString();
    }
    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",3005)){
            Scanner sc=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Enter the number in the format(100101) : ");
            String str=sc.next();

            str=check(str);
            out.println(str);

            String s=in.readLine();

            System.out.println(s);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}