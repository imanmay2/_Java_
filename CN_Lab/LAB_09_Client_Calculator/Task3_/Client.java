import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5002);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();
        System.out.print("Enter number of subnets: ");
        int subnets = sc.nextInt();

        // Send to server
        out.println(ip);
        out.println(subnets);

        // Receive from server
        String line;
        while (!(line = in.readLine()).equals("END")) {
            System.out.println(line);
        }

        sc.close();
        socket.close();
    }
}
