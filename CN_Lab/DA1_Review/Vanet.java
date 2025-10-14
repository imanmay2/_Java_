import java.util.*;

public class Vanet {
    private List<String> nodes;

    public Vanet() {
        nodes = new ArrayList<>();
    }

    public void addNode(String node) {
        nodes.add(node);
        System.out.println("Node added: " + node);
    }

    public void broadcast(String sender, String message) {
        for (String node : nodes) {
            if (!node.equals(sender)) {
                System.out.println("Message from " + sender + " to " + node + ": " + message);
            }
        }
    }

    public static void main(String[] args) {
        Vanet v = new Vanet();
        v.addNode("Car1");
        v.addNode("Car2");
        v.addNode("Car3");

        v.broadcast("Car1", "Traffic ahead!");
    }
}
