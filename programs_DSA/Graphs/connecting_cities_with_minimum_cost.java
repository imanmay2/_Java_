import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;

public class connecting_cities_with_minimum_cost {
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v, path;

        public Pair(int v, int path) {
            this.v = v;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int list[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] != 0) {
                    graph[i].add(new Edge(i, j, list[i][j]));

                }
            }
        }

        System.out.println("Graph created successfully.");
    }

    public static void minimumConnectingCities(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        int ans = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                ans += curr.path;

                // visiting the neighbours
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum Cost connecting the cities are : " + ans);
    }

    public static void main(String args[]) {
        ArrayList<Edge> graph[] = new ArrayList[5];
        int list[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 },
        };

        createGraph(graph, list);
        minimumConnectingCities(graph, 0);

    }
}
