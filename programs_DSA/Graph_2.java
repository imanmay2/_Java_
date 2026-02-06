import java.util.ArrayList;

public class Graph_2 {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        // detect cycle code for undirected graph.
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                return detectCycleUtil(graph, vis, i, -1);
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] && e.dest != par) {
                return true;
            }
            if (!vis[e.dest]) {
                return detectCycleUtil(graph, vis, e.dest, curr);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // adding manually for the 2 unconnected graph.
        // Component 1
        // graph[0].add(new Edge(0, 1));
        // graph[1].add(new Edge(1, 0));

        // graph[1].add(new Edge(1, 2));
        // graph[2].add(new Edge(2, 1));

        // // Component 2
        // graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 3));

        // graph[4].add(new Edge(4, 5));
        // graph[5].add(new Edge(5, 4));

        // Component 1 (Cycle exists)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3)); // This edge creates the cycle

        // Component 2 (No cycle)
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        // dfs(graph);
        System.out.println(detectCycle(graph));
    }
}
