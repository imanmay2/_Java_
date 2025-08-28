// Develop a Java Program to implement  hamming code mechanism which generates codeword for the given data word for n bits of data word using even parity. 
// Display the intermediate steps  results along with the code word.

import java.util.Scanner;
// Reg No: 24BAI1316
public class hammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of data bits: ");
        int m = sc.nextInt();
        int[] data = new int[m];
        System.out.println("Enter " + m + " data bits:");
        for (int i = 0; i < m; i++) {
            data[i] = sc.nextInt();
        }
        int r = 0;
        while (Math.pow(2, r) < m + r + 1) {
            r++;
        }
        System.out.println("Parity bits required: " + r);
        int[] code = new int[m + r];
        int j = 0;
        for (int i = 1; i <= code.length; i++) {
            if ((i & (i - 1)) == 0) {
                code[i - 1] = 0;
            } else {
                code[i - 1] = data[j];
                j++;
            }
        }
        System.out.print("After placing data (0=parity): ");
        for (int bit : code) {
            System.out.print(bit);
        }
        System.out.println();
        for (int i = 0; i < r; i++) {
            int pos = (int) Math.pow(2, i);
            int count = 0;
            for (int k = 1; k <= code.length; k++) {
                if (((k >> i) & 1) == 1 && code[k - 1] == 1) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                code[pos - 1] = 0;
            } else {
                code[pos - 1] = 1;
            }
            System.out.println("Parity bit at position " + pos + " = " + code[pos - 1]);
        }
        System.out.print("Final Hamming Code: ");
        for (int bit : code) {
            System.out.print(bit);
        }
        System.out.println();
    }
}