import java.util.ArrayList;

public class Graph_3 {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void all_paths(ArrayList<Edge> graph[],int src,int dest,ArrayList<Integer> list,boolean[] vis){
        
        if(src==dest){
            list.add(dest);
            printAL(list);
            list.remove(list.size()-1);
            return;
        }

        list.add(src);
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest]){
                all_paths(graph, e.dest, dest, list, vis);
            }
        }
        //backtracking
        list.remove(list.size()-1);
    }

    public static void printAL(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // take manually.

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[0].add(new Edge(0, 3));

        graph[3].add(new Edge(3, 1));

        all_paths(graph, 5, 1, new ArrayList<>(), new boolean[V]);
    }
}
