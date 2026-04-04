// Develop a client - server program to transfer the text message from server to client  
// and display the same in client till the user types "End" message in server side using Java.

//NAME : Manmay Chakraborty
// Reg No: : 24BAI1316
import java.io.*;
import java.net.*;

public class client {
    private Socket socket = null;
    private DataInputStream input = null;

    public client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream())); // getting data from server

        } catch (UnknownHostException u) {
            System.out.println(u);
            return;
        } catch (IOException i) {
            System.out.println(i);
            return;
        }

        String line="";
        while (!line.equals("End")) {
            try {
                System.out.println(input.readUTF());
            } catch (IOException i) {
                System.out.println(i);
                return;
            }
        }

        try {
            input.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
            return;
        }
    }

    public static void main(String args[]) {
        client cli = new client("127.0.0.1", 5001);
    }
}
