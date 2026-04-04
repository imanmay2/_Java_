import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9400);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter domain name: ");
        String domain = sc.nextLine();

        writer.println(domain);
        String reply = reader.readLine();

        System.out.println("DNS Server Reply: " + reply);

        writer.close();
        reader.close();
        socket.close();
        sc.close();
    }
}
