import java.io.*;
import java.net.*;

public class Server {

    // Print the 2D matrix in a readable way
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Check 2D parity (rows + columns) for error detection
    private static boolean checkParity(int[][] matrix, int rows, int cols) {
        // Check row parity
        for (int i = 0; i < rows; i++) {
            int rowParity = 0;
            for (int j = 0; j < cols; j++) {
                rowParity ^= matrix[i][j];
            }
            if (rowParity != matrix[i][cols]) {
                return false;
            }
        }

        // Check column parity
        for (int j = 0; j <= cols; j++) {
            int colParity = 0;
            for (int i = 0; i < rows; i++) {
                colParity ^= matrix[i][j];
            }
            if (colParity != matrix[rows][j]) {
                return false;
            }
        }

        return true;
    }

    // Decode the 2D matrix back into the registration number string
    private static String decode(int[][] matrix, int rows, int cols) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            int val = 0;
            for (int j = 0; j < cols; j++) {
                val = (val << 1) | matrix[i][j];
            }
            sb.append((char) val);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Server is running... Waiting for client.");

            try (
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Receive encoded data
                String data = in.readLine();
                System.out.println("Received encoded data from client: " + data);

                // Validate data length
                if (data == null || data.length() % 9 != 0) {
                    out.println("Error - Invalid data length");
                    return;
                }

                int rows = (data.length() / 9) - 1;  // last row = parity
                int cols = 8;  // each char is 8 bits
                int[][] matrix = new int[rows + 1][cols + 1];

                // Convert string into matrix
                int idx = 0;
                for (int i = 0; i <= rows; i++) {
                    for (int j = 0; j <= cols; j++) {
                        matrix[i][j] = data.charAt(idx++) - '0';
                    }
                }

                System.out.println("Received 2D matrix:");
                printMatrix(matrix);

                // Check for errors
                if (checkParity(matrix, rows, cols)) {
                    String regNo = decode(matrix, rows, cols);
                    System.out.println("✅ No error detected. Registration number: " + regNo);
                    out.println("No Error");
                } else {
                    System.out.println("❌ Error detected! Asking client to resend.");
                    out.println("Error - Resend");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
