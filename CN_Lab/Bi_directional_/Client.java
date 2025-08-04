import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    // Reg No : 24BAI1316, Name : Manmay Chakraborty
    
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5001)) {
             // Sample string to send
           // String str = "Hello from client!";
           // to read string from the user
              Scanner scanner = new Scanner(System.in);
            // To send string to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // To read response from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                     

        System.out.print("Enter a string: ");
        String str = scanner.nextLine(); 
            System.out.println("Sending string to server: " + str);
            out.println(str);

            // Read length from server
            String length = in.readLine();
            System.out.println("Length of string received from server: " + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}