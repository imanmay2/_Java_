import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    // Convert a character to its 8-bit binary representation
    private static String toBinary(char c) {
        String bin = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
        System.out.println("Char '" + c + "' -> ASCII: " + (int) c + " -> Binary: " + bin);
        return bin;
    }

    // Create 2D matrix with row and column parity bits
    private static int[][] createMatrix(String data) {
        int rows = data.length();
        int cols = 8; // Each character = 8 bits
        int[][] matrix = new int[rows + 1][cols + 1];

        System.out.println("\nConverting each character to 8-bit binary and filling matrix:");
        for (int i = 0; i < rows; i++) {
            String bin = toBinary(data.charAt(i));
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = bin.charAt(j) - '0';
            }
        }

        // Calculate row parity bits
        System.out.println("\nCalculating row parity bits:");
        for (int i = 0; i < rows; i++) {
            int parity = 0;
            for (int j = 0; j < cols; j++) {
                parity ^= matrix[i][j];
            }
            matrix[i][cols] = parity;
            System.out.println("Row " + i + " parity: " + parity);
        }

        // Calculate column parity bits
        System.out.println("\nCalculating column parity bits:");
        for (int j = 0; j <= cols; j++) {
            int parity = 0;
            for (int i = 0; i < rows; i++) {
                parity ^= matrix[i][j];
            }
            matrix[rows][j] = parity;
            System.out.println("Column " + j + " parity: " + parity);
        }

        return matrix;
    }

    // Flatten 2D matrix into a single string for transmission
    private static String flatten(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        System.out.println("\nFlattening 2D matrix into 1D string:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val);
                sb.append(val);
            }
        }
        System.out.println();
        return sb.toString();
    }

    // Manually flip a bit at the given position
    private static String manuallyFlipBit(String data, int position) {
        char[] chars = data.toCharArray();
        chars[position] = (chars[position] == '0') ? '1' : '0';
        System.out.println("\nManually flipped bit at position " + position);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input registration number
        System.out.print("Enter Registration Number: ");
        String regNo = sc.nextLine();

        // Step 2: Encode into binary + parity matrix
        int[][] matrix = createMatrix(regNo);
        String dataToSend = flatten(matrix);

        // Step 3: Ask user to flip a bit manually
        System.out.print("Enter the bit position to flip (0 to " + (dataToSend.length() - 1) + "): ");
        int bitPositionToFlip = sc.nextInt();
        while (bitPositionToFlip < 0 || bitPositionToFlip >= dataToSend.length()) {
            System.out.println("Invalid position. Enter between 0 and " + (dataToSend.length() - 1));
            bitPositionToFlip = sc.nextInt();
        }

        String dataWithError = manuallyFlipBit(dataToSend, bitPositionToFlip);

        // Step 4: Send data to server
        try (
            Socket socket = new Socket("localhost", 5001);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("\nSending encoded data to server: " + dataWithError);
            out.println(dataWithError);

            // Step 5: Receive server response
            String response = in.readLine();
            System.out.println("\nServer response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
