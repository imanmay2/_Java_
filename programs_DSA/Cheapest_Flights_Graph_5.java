import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_Flights_Graph_5 {
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 5));

        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 3, 1));

    }

    static class Info{
        int v,path,s;
        public Info(int v,int path,int s){
            this.v=v;
            this.path=path;
            this.s=s;
        }
    }

    public static void CheapestDistance(ArrayList<Edge> graph[], int src, int dest, int k) {
        k++;
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q1=new LinkedList<>();
        q1.add(new Info(src, 0, 0));

        while(!q1.isEmpty()){
            Info curr=q1.remove();

            if(curr.s>k){
                continue;
            }

            //visiting the neighbouring element. 
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);

                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                //relaxation 
                if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt<dist[v] && curr.s<=k){
                    dist[v]=dist[u]+wt;
                    q1.add(new Info(v, dist[v], curr.s+1));
                }
            }
        }

        System.out.println("Cheapest Cost within k stops is : "+dist[dest]);
    }
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        CheapestDistance(graph, 0, 3, 1);
    }
}