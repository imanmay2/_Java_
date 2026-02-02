import java.util.*;
import java.util.LinkedList;

public class Graph_1 {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void BFS(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(0);
        boolean arr[] = new boolean[V];

        // initialize the array to false
        for (int i = 0; i < V; i++) {
            arr[i] = false;
        }

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!arr[curr]) {
                System.out.print(curr + " ");
                arr[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q1.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void main(String args[]) {

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // adding manually
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(4, 4));
        graph[5].add(new Edge(4, 6));

        graph[6].add(new Edge(6, 5));

        BFS(graph, V);

    }
}