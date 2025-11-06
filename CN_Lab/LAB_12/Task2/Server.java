import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9100);
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);

            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] parts = receivedData.split(",");
            int number = Integer.parseInt(parts[0].trim());
            String service = parts[1].trim().toLowerCase();

            String replyMessage;
            if (service.equals("prime")) {
                boolean isPrime = true;
                if (number <= 1) isPrime = false;
                else {
                    for (int i = 2; i <= Math.sqrt(number); i++) {
                        if (number % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                replyMessage = "Number " + number + (isPrime ? " is Prime." : " is Not Prime.");
            } else if (service.equals("even_odd")) {
                replyMessage = "Number " + number + (number % 2 == 0 ? " is Even." : " is Odd.");
            } else {
                replyMessage = "Invalid service request. Please use 'prime' or 'even_odd'.";
            }

            byte[] replyBytes = replyMessage.getBytes();
            DatagramPacket replyPacket = new DatagramPacket(
                replyBytes,
                replyBytes.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
            );

            serverSocket.send(replyPacket);
        }
    }
}
