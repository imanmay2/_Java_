import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    // XOR operation between two binary strings
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
        for (int i = 0; i < length; i++) sb.append('0');
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

    // Generate codeword (data + remainder)
    private static String generateCodeword(String data, String divisor) {
        System.out.println("Data to be sent (dividend): " + data);
        String appended = data + zeroString(divisor.length() - 1);
        System.out.println("Data appended with zeros: " + appended);

        String remainder = mod2div(appended, divisor);
        System.out.println("Generated remainder: " + remainder);

        return data + remainder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (
            Socket socket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Input from user
            System.out.print("Enter binary data (dividend, e.g., 1010001111): ");
            String data = scanner.nextLine();

            System.out.print("Enter binary divisor polynomial (e.g., 110101): ");
            String divisor = scanner.nextLine();

            // Generate codeword
            String codeword = generateCodeword(data, divisor);
            System.out.println("Generated codeword before flipping: " + codeword);

            // Error simulation
            System.out.print("Enter bit position to flip (0-based from right, or -1 for no flip): ");
            int flipPosFromRight = Integer.parseInt(scanner.nextLine());

            if (flipPosFromRight >= 0 && flipPosFromRight < codeword.length()) {
                int flipPosFromLeft = codeword.length() - 1 - flipPosFromRight;
                char bitToFlip = codeword.charAt(flipPosFromLeft);
                char flippedBit = (bitToFlip == '0') ? '1' : '0';

                codeword = codeword.substring(0, flipPosFromLeft) + flippedBit + codeword.substring(flipPosFromLeft + 1);

                System.out.println("Codeword after flipping bit at position " + flipPosFromRight + " (from right): " + codeword);
            } else if (flipPosFromRight != -1) {
                System.out.println("Invalid flip position entered. Sending codeword without flipping.");
            } else {
                System.out.println("No bit flip selected. Sending original codeword.");
            }

            // Send to server
            System.out.println("Final codeword sent to server: " + codeword);
            out.println(codeword);

            // Receive server response
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
