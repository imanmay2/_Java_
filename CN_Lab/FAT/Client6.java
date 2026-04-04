import java.util.*;
import java.net.*;
import java.io.*;

public class Client6{

    public static void func1(ArrayList<String> list,String str){
        for(int i=0;i<str.length();i++){
            int ascii=(int)str.charAt(i);
            String s=String.format("%8s", Integer.toBinaryString(ascii).replace(" ","0"));

            list.add(s);
        }
    }

    public static void print_(ArrayList<String> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }


    public static void modify(ArrayList<String> list){
        for(int i=0;i<list.size();i++){
            int ct=0;
            String s="";
            for(int j=0;j<list.get(i).length();j++){
                s=list.get(i);
                if(s.charAt(j)=='1'){
                    ct++;
                }
            }

            if(ct%2==0){
                s=s+'0';
            }else{
                s=s+'1';
            }

            list.set(i,s);
        }
    }


    public static void main(String args[]){
        try(Socket socket=new Socket("localhost",7005)){
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            System.out.println("String entered : "+str);
            ArrayList<String> list=new ArrayList<>();
            
            func1(list, str);
            print_(list);

            System.out.println("2D parity matrix is : ");
            modify(list);
            print_(list);

            String str_=list.toString();

            out.println(str_);


            // String s=in.readLine();

            // System.out.println("Recieved from the client.");
            // System.out.println(s);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}