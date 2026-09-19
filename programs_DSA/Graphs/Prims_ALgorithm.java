import java.util.*;

public class Prims_ALgorithm {

    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Priority Queue
    static class Pair implements Comparable<Pair> {
        int v, c;

        public Pair(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.c - p2.c; // sorts in ascending order
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Edges from node 0
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // Edges from node 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // Edges from node 2
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // Edges from node 3
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static void Prims(ArrayList<Edge> graph[]){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[graph.length];
        pq.add(new Pair(0, 0));

        int cost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                cost+=curr.c;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum cost of the Spanning Tree is : "+cost);
    }

    public static void main(String args[]) {
        ArrayList<Edge> graph[]=new ArrayList[4];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        createGraph(graph);

        Prims(graph);
    }
}