class Solution {
    class Pair{
        int n,cost,k;
        public Pair(int n,int cost,int k){
            this.n=n;
            this.cost=cost;
            this.k=k;
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
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(graph,flights);
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(curr.k>=k){
                continue;
            }
            //vis the neigh
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e=graph[curr.n].get(i);
                int wt=e.wt;
                int v=e.dest;
                if(curr.cost+wt<dist[v] && curr.k<k){
                    dist[v]=curr.cost+wt;
                    pq.add(new Pair(v,dist[v],curr.k+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}