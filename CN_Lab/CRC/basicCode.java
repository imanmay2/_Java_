import java.util.Scanner;

public class basicCode {

    // Perform modulo-2 division and return the remainder (CRC)
    private static String xorDivide(String dividend, String divisor) {
        int pick = divisor.length();
        String temp = dividend.substring(0, pick);
        while (pick < dividend.length()) {
            if (temp.charAt(0) == '1') {
                // XOR with divisor
                temp = xor(divisor, temp) + dividend.charAt(pick);
            } else {

                // XOR with all 0’s

                temp = xor("0".repeat(pick), temp) + dividend.charAt(pick);

            }

            pick++;

        }

        // Last n bits

        if (temp.charAt(0) == '1') {

            temp = xor(divisor, temp);

        } else {

            temp = xor("0".repeat(pick), temp);

        }

        return temp.substring(1); // remainder (CRC)

    }

    // XOR operation on two binary strings

    private static String xor(String a, String b) {

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < b.length(); i++) {

            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');

        }

        return result.toString();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary data: ");

        String data = sc.nextLine();

        System.out.print("Enter binary divisor (polynomial): ");

        String divisor = sc.nextLine();

        int n = divisor.length();

        String appendedData = data + "0".repeat(n - 1);

        // Sender side: generate CRC

        String remainder = xorDivide(appendedData, divisor);

        String transmitted = data + remainder;

        System.out.println("\n--- Sender Side ---");

        System.out.println("Data: " + data);

        System.out.println("Divisor: " + divisor);

        System.out.println("Appended Data: " + appendedData);

        System.out.println("CRC: " + remainder);

        System.out.println("Transmitted: " + transmitted);

        // Receiver side: check CRC

        System.out.print("\nEnter received data: ");

        String received = sc.nextLine();

        String checkRemainder = xorDivide(received, divisor);

        System.out.println("\n--- Receiver Side ---");

        System.out.println("Received Data: " + received);

        System.out.println("Remainder: " + checkRemainder);

        if (Integer.parseInt(checkRemainder) == 0) {

            System.out.println("No Error (Data is correct)");

        } else {

            System.out.println(" Error Detected in Received Data");

        }

        sc.close();

    }

}