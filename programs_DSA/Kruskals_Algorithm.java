import java.util.ArrayList;
import java.util.Collections;

public class Kruskals_Algorithm {
    static int n = 8;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x];
    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]>rank[parB]){
            par[parB]=parA;

        }else{
            par[parA]=parB;
        }
    }

    static class Edge implements Comparable<Edge>{
        int src,dest,wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }

        
    }

    public static void createGraph(ArrayList<Edge> list){
        list.add(new Edge(0,1, 10));
        list.add(new Edge(0,3, 30));
        list.add(new Edge(0,2, 15));

        list.add(new Edge(1,3, 40));
        list.add(new Edge(3,2, 50));
    }

    public static int kruskalAlgorithm(ArrayList<Edge> list){
        int v=list.size()-1;
        Collections.sort(list);
        int ct=0;
        int cost=0;
        for(int i=0;ct<v-1;i++){
            Edge e=list.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(par[parA]!=par[parB]){
                union(parA, parB);
                cost+=e.wt;
                ct++;
            }
        }

        return cost;
    }

    public static void main(String args[]) {
        init(); //initialization function. 
        ArrayList<Edge> list=new ArrayList<>();
        createGraph(list);
        System.out.println(kruskalAlgorithm(list));
    }
}