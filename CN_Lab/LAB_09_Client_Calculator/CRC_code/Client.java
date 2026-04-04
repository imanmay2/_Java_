import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

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
        String host = "localhost";
        int port = 5008;
        String divisor = "1011";

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter binary data: ");
            String data = sc.nextLine();

            int n = divisor.length();
            String appendedData = data + "0".repeat(n - 1);
            String remainder = xorDivide(appendedData, divisor);
            String transmitted = data + remainder;

            System.out.println("CRC: " + remainder);
            System.out.println("Transmitted Data: " + transmitted);

            try (Socket socket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println(transmitted);
                String response = in.readLine();
                System.out.println("Server Response: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
