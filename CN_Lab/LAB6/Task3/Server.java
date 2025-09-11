import java.io.*;
import java.net.*;

public class Server {

    // Perform XOR operation between two binary strings
    private static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    // Generate a string of zeros of given length
    private static String zeroString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    // Perform Mod-2 division
    private static String mod2div(String dividend, String divisor) {
        int pick = divisor.length();

        if (pick > dividend.length()) {
            return zeroString(pick - 1);
        }

        String tmp = dividend.substring(0, pick);
        System.out.println("Initial tmp: " + tmp);

        while (pick < dividend.length()) {
            if (tmp.length() == 0) {
                return zeroString(divisor.length() - 1);
            }

            if (tmp.charAt(0) == '1') {
                System.out.println("tmp starts with 1, XOR with divisor");
                tmp = xor(divisor, tmp) + dividend.charAt(pick);
            } else {
                System.out.println("tmp starts with 0, XOR with zeros");
                tmp = xor(zeroString(tmp.length()), tmp) + dividend.charAt(pick);
            }

            pick++;
            tmp = (tmp.length() > 1) ? tmp.substring(1) : "";
            System.out.println("Updated tmp: " + tmp);
        }

        if (tmp.length() == 0) {
            return zeroString(divisor.length() - 1);
        }

        if (tmp.charAt(0) == '1') {
            System.out.println("Final XOR with divisor");
            tmp = xor(divisor, tmp);
        } else {
            System.out.println("Final XOR with zeros");
            tmp = xor(zeroString(tmp.length()), tmp);
        }

        System.out.println("Remainder: " + tmp);
        return tmp;
    }

    // Check if the received codeword has errors
    private static boolean checkCodeword(String data, String divisor) {
        System.out.println("Checking codeword: " + data);
        String remainder = mod2div(data, divisor);
        System.out.println("Remainder from check: " + remainder);
        return !remainder.contains("1");
    }

    public static void main(String[] args) {
        String divisor = "110101";

        try (ServerSocket serverSocket = new ServerSocket(5007)) {
            System.out.println("Server started. Waiting for client...");

            try (
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                System.out.println("Client connected.");

                String received = in.readLine();
                System.out.println("Received codeword: " + received);

                boolean noError = checkCodeword(received, divisor);

                if (noError) {
                    out.println("No Error detected.");
                    System.out.println("No Error detected.");
                } else {
                    out.println("Error detected!");
                    System.out.println("Error detected!");
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
