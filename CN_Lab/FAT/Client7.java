import java.util.*;
import java.io.*;
import java.net.*;

public class Client7 {
    public static void main(String args[]) {
        try (Socket socket = new Socket("localhost", 5009)) {
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // object for sending the input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str="";
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}