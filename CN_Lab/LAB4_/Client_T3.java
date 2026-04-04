// Develop a client server program using 
// Hamming distance in which client sends a data word as a code word  
// and server receives the same. Then it checks whether there is an error in received data. 
// If it is an error it discards the data
//  and informs the same to the client else display the data in server side.

import java.io.*;
import java.net.*;
import java.util.*;

public class Client_T3{
    public static void main(String args[]) {
        try (Socket socket = new Socket("127.0.0.1", 5003)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the original data word (binary): ");
            String originalData = sc.nextLine();
            System.out.print("Enter the transmitted data word (binary, possibly with error): ");
            String transmittedData = sc.nextLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(originalData);   
            out.println(transmittedData); 
            String response = in.readLine();
            System.out.println("Server says: " + response);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}