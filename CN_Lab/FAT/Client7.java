import java.util.*;
import java.io.*;
import java.net.*;

public class Client7 {
    public static void main(String args[]) {
        try (Socket socket = new Socket("localhost", 8007)) {
            Scanner sc = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Reading continuos msg from the server.
            new Thread(() -> {
                try {
                    String msg = "";
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);

                    }
                } catch (IOException e) {
                }
            }).start();

            while (true) {
                System.out.println("Enter the msg : ");
                String str = sc.nextLine();
                if(str.equals("end")){
                    break;
                }
                out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}