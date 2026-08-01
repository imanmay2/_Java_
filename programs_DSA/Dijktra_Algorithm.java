import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijktra_Algorithm {

    static class Pair implements Comparable<Pair>{
        int n,cost;
        public Pair(int n,int cost){
            this.n=n;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }


    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    // print the neighbouring elements.
    public static void printNeigh(ArrayList<Edge> graph[], int n) {
        System.out.println("Neighbouring Elements : ");
        for (int i = 0; i < graph[n].size(); i++) {
            Edge e = graph[n].get(i);
            System.out.println(e.dest);
        }
    }

    public static void main(String args[]) {
        int V = 6;

        int[][] edges = {
                { 0, 1, 5 },
                { 0, 2, 1 },
                { 1, 3, 2 },
                { 2, 1, 3 },
                { 2, 4, 7 },
                { 3, 5, 1 },
                { 4, 5, 2 }
        };

        ArrayList<Edge> graph[] = new ArrayList[V];
        // creating a adjancancy list from edges array.
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph, edges);

        //shortest distance---


        int dist[]=new int[V];
        boolean vis[]=new boolean[V];
        int src=0;
        //step : 1 make the distance infinite
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }


        //step-2 , use algorithm BFS fashion using Priority Queue
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                //visit neigh
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        //print the shortest element : 

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }
    }
}