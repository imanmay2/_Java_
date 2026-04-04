import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static int[] generateHammingCode(int[] data) {
        int m = data.length;
        int r = 0;
        while (Math.pow(2, r) < m + r + 1) {
            r++;
        }
        int[] code = new int[m + r];
        int j = 0;
        System.out.println("Placing data bits and parity bits:");
        for (int i = 1; i <= code.length; i++) {
            if ((i & (i - 1)) == 0) {
                code[i - 1] = 0; 
                System.out.println("Position " + i + " : Parity bit (placeholder 0)");
            } else {
                code[i - 1] = data[j++];
                System.out.println("Position " + i + " : Data bit = " + code[i - 1]);
            }
        }
        System.out.println("\nCalculating parity bits (even parity):");
        for (int i = 0; i < r; i++) {
            int pos = (int) Math.pow(2, i);
            int count = 0;
            System.out.print("Parity bit at position " + pos + " covers bits: ");
            for (int k = pos; k <= code.length; k++) {
                if (((k >> i) & 1) == 1) {
                    System.out.print(k + " ");
                    if (code[k - 1] == 1) count++;
                }
            }
            code[pos - 1] = (count % 2 == 0) ? 0 : 1;
            System.out.println(" -> Parity bit = " + code[pos - 1]);
        }
        return code;
    }

    public static void printArray(int[] arr) {
        for (int bit : arr) System.out.print(bit);
        System.out.println();
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5001);
             Scanner sc = new Scanner(System.in);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Enter data bits as a string (e.g. 1011): ");
            String dataStr = sc.nextLine();
            int[] data = new int[dataStr.length()];
            for (int i = 0; i < dataStr.length(); i++) {
                data[i] = dataStr.charAt(i) - '0';
            }

            System.out.println("\nGenerating Hamming Code:");
            int[] hammingCode = generateHammingCode(data);

            System.out.print("\nGenerated Hamming Codeword: ");
            printArray(hammingCode);

            StringBuilder sb = new StringBuilder();
            for (int bit : hammingCode) sb.append(bit);

            System.out.println("\nSending the codeword to server...");
            out.println(sb.toString());

            System.out.println("\nReceiving verification from server...");
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
                if (!in.ready()) break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}