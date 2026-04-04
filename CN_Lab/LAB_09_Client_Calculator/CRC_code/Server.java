import java.io.*;
import java.net.*;

public class Server {

    public static String xorDivide(String dividend, String divisor) {
        int divisorLength = divisor.length();
        int currentIndex = divisorLength;
        String temp = dividend.substring(0, divisorLength);

        while (currentIndex < dividend.length()) {
            if (temp.charAt(0) == '1') {
                temp = xor(divisor, temp) + dividend.charAt(currentIndex);
            } else {
                temp = xor("0".repeat(divisorLength), temp) + dividend.charAt(currentIndex);
            }
            currentIndex++;
        }

        if (temp.charAt(0) == '1') {
            temp = xor(divisor, temp);
        } else {
            temp = xor("0".repeat(divisorLength), temp);
        }

        return temp.substring(1);
    }

    private static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int port = 5008;
        String divisor = "1011";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("CRC Server started. Waiting for client...");

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Client connected!");

                String receivedData = in.readLine();
                System.out.println("Received Data: " + receivedData);

                String remainder = xorDivide(receivedData, divisor);
                System.out.println("Remainder: " + remainder);

                if (remainder.replace("0", "").isEmpty()) {
                    out.println("No Error (Data is correct)");
                } else {
                    out.println("Error Detected in Received Data");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
