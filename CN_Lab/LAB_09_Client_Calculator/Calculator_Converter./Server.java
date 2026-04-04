import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        final int PORT = 5001;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Calculator Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void handleClient(Socket clientSocket) {
        try (
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())
        ) {
            float num1 = Float.parseFloat(input.readUTF());
            float num2 = Float.parseFloat(input.readUTF());
            String operator = input.readUTF();
            System.out.println("Request: " + num1 + " " + operator + " " + num2);
            String result = calculate(num1, num2, operator);
            output.writeUTF(result);
            System.out.println("Result sent: " + result);
        } catch (IOException e) {
            System.err.println("Client communication error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnected");
            } catch (IOException ignored) {}
        }
    }

    private static String calculate(float num1, float num2, String operator) {
        switch (operator) {
            case "A": return String.valueOf(num1 + num2);
            case "S": return String.valueOf(num1 - num2);
            case "M": return String.valueOf(num1 * num2);
            case "D":
                if (num2 == 0) return "Error: Division by zero!";
                return String.valueOf(num1 / num2);
            default:  return "Error: Unknown operator '" + operator + "'";
        }
    }
}
