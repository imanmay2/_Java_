import java.io.*;
import java.net.*;
public class Server_T3{
    // Calculate Hamming distance 
    public static int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Strings must be of equal length");
        }
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        int port = 5003;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server running on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String sentData = in.readLine();      
            String receivedData = in.readLine();  
            System.out.println("Sent Data (claimed): " + sentData);
            System.out.println("Received Data: " + receivedData);
            int distance = hammingDistance(sentData, receivedData);
            if (distance == 0) {
                System.out.println("No error. Data word accepted: " + receivedData);
                out.println("No error. Data received successfully: " + receivedData);
            } else {
                System.out.println("Error detected! Hamming Distance = " + distance);
                out.println("Error detected! Distance = " + distance + ". Data discarded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
