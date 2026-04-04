import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static int ipToInt(int[] octets) {
        return (octets[0] << 24) | (octets[1] << 16) | (octets[2] << 8) | octets[3];
    }
    private static String intToIp(int ip) {
        return String.format("%d.%d.%d.%d",
                (ip >> 24) & 0xFF,
                (ip >> 16) & 0xFF,
                (ip >> 8) & 0xFF,
                ip & 0xFF);
    }
    private static char getClass(int firstOctet) {
        if (firstOctet >= 1 && firstOctet <= 126) return 'A';
        else if (firstOctet >= 128 && firstOctet <= 191) return 'B';
        else if (firstOctet >= 192 && firstOctet <= 223) return 'C';
        else if (firstOctet >= 224 && firstOctet <= 239) return 'D';
        else return 'E';
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5002);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Receive input
        String ip = in.readLine();
        int subnets = Integer.parseInt(in.readLine());
        System.out.println("📩 Received IP: " + ip + " | Subnets: " + subnets);
        // Split into octets
        String[] parts = ip.split("\\.");
        int[] octets = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        char ipClass = getClass(octets[0]);
        out.println("IP Class: " + ipClass);
        if (ipClass == 'D' || ipClass == 'E') {
            out.println("Class " + ipClass + " addresses are reserved (not subnetted).");
            out.println("END");
            socket.close();
            serverSocket.close();
            return;
        }
        // Default mask based on class
        int defaultMask;
        if (ipClass == 'A') defaultMask = 8;
        else if (ipClass == 'B') defaultMask = 16;
        else defaultMask = 24; // Class C
        int bitsNeeded = (int) Math.ceil(Math.log(subnets) / Math.log(2));
        int newMask = defaultMask + bitsNeeded;
        int blockSize = (int) Math.pow(2, (32 - newMask));
        out.println("New Subnet Mask: /" + newMask);
        int network = ipToInt(octets) & (-1 << (32 - defaultMask)); // base network
        for (int i = 0; i < subnets; i++) {
            int subnetAddr = network + (i * blockSize);
            int firstAddr = subnetAddr + 1;
            int lastAddr = subnetAddr + blockSize - 2;
            String subnetStr = String.format("Subnet %d -> First: %s, Last: %s",
                    i + 1,
                    intToIp(firstAddr),
                    intToIp(lastAddr));

            out.println(subnetStr);
        }
        out.println("END");
        socket.close();
        serverSocket.close();
    }
}