class Solution {
    class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public boolean dfs(List<Edge> graph[],boolean stack[],boolean vis[],int curr){
        stack[curr]=true;
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            //visiting the neighbouring element
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }

            if(!vis[e.dest] && dfs(graph,stack,vis,e.dest)){
                return true;
            }
        }

            //backtrack
            stack[curr]=false;
            return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Edge> graph[]=new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            Edge e=new Edge(prerequisites[i][1],prerequisites[i][0]);
            graph[prerequisites[i][1]].add(e);
        }

        //Array List created. 
        //now check whether the graph is cyclic or not. (for directed graph)
        boolean vis[]=new boolean[numCourses];
        boolean stack[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(graph,stack,vis,i)){
                    //hence cycle exists can't take the course
                    return false;
                }
            }
        }
        return true;
    }
}