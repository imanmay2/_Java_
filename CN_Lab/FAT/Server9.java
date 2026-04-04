import java.util.*;
import java.io.*;
import java.net.*;

public class Server9 {
    public static void main(String args[]){
        try(ServerSocket serverSocket=new ServerSocket(5009)){
            System.out.println("Waiting for the client..");
            ArrayList<Socket> list=new ArrayList<>();
            while(true){
                Socket socket=serverSocket.accept();
                list.add(socket);
                System.out.println("Client connected..");
                new Thread(()->{
                    try{
                        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String str="";

                    while((str=in.readLine())!=null){
                        System.out.println("From : "+socket+"got : "+str);
                        for(Socket s:list){
                            if(!s.isClosed()){
                                new PrintWriter(socket.getOutputStream(),true).println("Data received : "+str);
                            }
                        }
                    }
                    }catch(Exception e){
                        System.out.println("Client not connected.");
                    }
                }).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
