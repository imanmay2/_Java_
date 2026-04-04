import java.util.LinkedList;
import java.util.*;

public class Bipartite_Graph {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q1 = new LinkedList<>();

        q1.add(0);
        color[0] = 1;
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!vis[curr] && color[curr] != -1) {
                // color[curr]=1;
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.dest);
                    if (color[e.dest] == color[curr]) {
                        return false;
                    }
                    if (color[curr] == 1) {
                        color[e.dest] = 2;
                    } else {
                        color[e.dest] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}