import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class graph_part1{
    static class Edge{
        int src,dest,wt;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    
    public static void BFS(ArrayList<Edge> graph[]){
        Queue<Integer> q1=new LinkedList<Integer>();
        boolean vis[]=new boolean[graph.length];
        q1.add(0);
        while(!q1.isEmpty()){
            int curr=q1.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    q1.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[],boolean vis[],int curr){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                DFS(graph,vis,e.dest);
            }
        }
    }


    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){

        //base case
        if(src==dest){
            return true;
        }

        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(2,4));
        graph[3].add(new Edge(3,5));


        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

        //now printing the neighbouring elements of 2. For checking purpose.

        // for(int i=0;i<graph[2].size();i++){
        //     System.out.println(graph[2].get(i).dest);
        // }
        // BFS(graph);

        DFS(graph,new boolean[graph.length],0);

        System.out.println();

        System.out.println(hasPath(graph, 0, 5, new boolean[graph.length]));
    }
}