import java.util.*;
import java.io.*;
import java.net.*;

public class Server7 {
    public static void main(String args[]) {
        try (ServerSocket serverSocket = new ServerSocket(8007)) {
            System.out.println("Waiting for Clients to join ..");
            ArrayList<Socket> clients = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client joined..");
                clients.add(socket);
                
                new Thread(() -> {
                    try {
                        String str = "";
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        

                        while ((str = in.readLine()) != null) {
                            System.out.println("From : " + socket + " got : " + str);
                            for (Socket s : clients) {
                                if (!(s.isClosed())) {
                                    new PrintWriter(s.getOutputStream(),true).println("Echo : " + str);
                                }
                            }
                        }

                    } catch (IOException e) {
                        System.out.println("Client is closed.");
                    }

                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}