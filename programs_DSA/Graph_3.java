import java.util.*;
import java.util.LinkedList;
public class Graph_3 {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void all_paths(ArrayList<Edge> graph[], int src, int dest, ArrayList<Integer> list, boolean[] vis) {

        if (src == dest) {
            list.add(dest);
            printAL(list);
            list.remove(list.size() - 1);
            return;
        }

        list.add(src);
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest]) {
                all_paths(graph, e.dest, dest, list, vis);
            }
        }
        // backtracking
        list.remove(list.size() - 1);
    }

    public static void printAL(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        // step 1 :calculate indegree
        int indeg[] = new int[graph.length];
        inDegree(graph, indeg);
        // printList(indeg);

        Queue<Integer> q1=new LinkedList<>();

        //initilization
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q1.add(i);
            }
        }

        System.out.println("Topological Sort is as follows : ");
        while(!q1.isEmpty()){
            int curr=q1.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q1.add(e.dest);
                }
            }
        } System.out.println();
    }

    public static void inDegree(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void printList(int indeg[]) {
        for (int i = 0; i < indeg.length; i++) {
            System.out.print(indeg[i] + " ");
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // take manually.

        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));

        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));

        // graph[2].add(new Edge(2, 3));

        // graph[0].add(new Edge(0, 3));

        // graph[3].add(new Edge(3, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        // all_paths(graph, 5, 1, new ArrayList<>(), new boolean[V]);
        topologicalSort(graph);
    }
}
