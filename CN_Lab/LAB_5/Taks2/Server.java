import java.io.*;
import java.net.*;

public class Server{
    // Detect and correct single-bit errors with simulated error flipping on server
    public static String detectAndCorrectWithError(int errorPosSim, String codewordStr) {
        int n = codewordStr.length();
        int[] codeword = new int[n];
        for (int i = 0; i < n; i++) {
            codeword[i] = codewordStr.charAt(i) - '0';
        }

        // Simulate error by flipping the bit at errorPosSim (1-based)
        if (errorPosSim >= 1 && errorPosSim <= n) {
            codeword[errorPosSim - 1] = 1 - codeword[errorPosSim - 1];
        }
        int r = 0;
        while (Math.pow(2, r) < n + 1) {
            r++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Received Hamming Code: ");
        for (int bit : codeword) sb.append(bit);
        sb.append("\n");
        int errorPos = 0;
        for (int i = 0; i < r; i++) {
            int parityPos = (int) Math.pow(2, i);
            int count = 0;
            sb.append("Checking parity bit at position ").append(parityPos).append(", covers bits: ");
            for (int j = parityPos; j <= n; j++) {
                if (((j >> i) & 1) == 1) {
                    sb.append(j).append(" ");
                    if (codeword[j - 1] == 1) count++;
                }
            }
            sb.append("\n");
            if (count % 2 != 0) {
                sb.append("Parity check failed at position ").append(parityPos).append("\n");
                errorPos += parityPos;
            } else {
                sb.append("Parity check passed at position ").append(parityPos).append("\n");
            }
        }

        if (errorPos == 0) {
            sb.append("No error detected in received codeword.\n");
        } else {
            sb.append("Error detected at position: ").append(errorPos).append(". Correcting error...\n");
            codeword[errorPos - 1] = 1 - codeword[errorPos - 1];
            sb.append("Corrected bit at position ").append(errorPos).append(".\n");
        }

        sb.append("Corrected codeword: ");
        for (int bit : codeword) sb.append(bit);
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Server started. Waiting for client...");
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String codewordStr = in.readLine();

                // Ask server operator for bit position to flip to simulate error or 0 for no error
                System.out.print("Enter position to flip bit for error simulation on server (0 for no error): ");
                int errorPosSim = Integer.parseInt(br.readLine());

                String result = detectAndCorrectWithError(errorPosSim, codewordStr);
                out.println(result);

                System.out.println("Operation done, connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}