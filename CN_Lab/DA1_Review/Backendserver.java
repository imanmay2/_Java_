import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Backendserver {
    private final int port;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public Backendserver(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Backend Server running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(() -> handleClient(clientSocket));
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Backend(" + port + ") received: " + line);
                String response = processCommand(line.trim());
                out.println("Response from backend " + port + ": " + response);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected from backend " + port);
        } finally {
            try { clientSocket.close(); } catch (IOException ignored) {}
        }
    }

    private String processCommand(String input) {
        if (input.isEmpty()) return "Empty input";

        String[] parts = input.split(" ", 2);
        String command = parts[0].toUpperCase();
        String data = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "UPPER":
                return data.toUpperCase();
            case "LOWER":
                return data.toLowerCase();
            case "REVERSE":
                return new StringBuilder(data).reverse().toString();
            case "LENGTH":
                return "Length: " + data.length();
            case "COUNT_VOWELS":
                return "Vowels: " + countVowels(data);
            case "COUNT_CONSONANTS":
                return "Consonants: " + countConsonants(data);
            case "REMOVE_SPACES":
                return data.replaceAll("\\s+", "");
            case "TOGGLE":
                return toggleCase(data);
            case "TITLE":
                return toTitleCase(data);
            case "PALINDROME":
                return isPalindrome(data) ? "Yes, it's a palindrome" : "No, not a palindrome";
            case "STATUS":
                return SystemMonitor.getSystemUsage();
            default:
                return "Unknown command: " + command;
        }
    }

    // Helper Methods
    private int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    private int countConsonants(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) count++;
        }
        return count;
    }

    private String toggleCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(c);
        }
        return sb.toString();
    }

    private String toTitleCase(String s) {
        String[] words = s.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1))
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    private boolean isPalindrome(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Backendserver <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new Backendserver(port).start();
    }
}
