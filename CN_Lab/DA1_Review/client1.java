import java.io.*;
import java.net.*;
import java.util.*;

public class client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        System.out.println("Connected to LoadBalancer on port 8000");
        while (true) {
            System.out.print("Enter message: ");
            String msg = sc.nextLine();
            out.println(msg);
            String response = in.readLine();
            System.out.println("Received: " + response);
        }
    }
}
