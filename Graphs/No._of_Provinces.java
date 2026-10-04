class Solution {

    //Approach : count the number of connected components use BFS/ DFS,. Mainly use DFS 
    public void dfs(int graph[][],boolean vis[],int curr){
        vis[curr]=true;
        for(int i=0;i<graph.length;i++){
            if(!vis[i] && graph[curr][i]==1){
                dfs(graph,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //adjancancy matrix is given. 
        //no need to change it to adjancency list. proceed and do the operation
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        int ct=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ct++;
                dfs(isConnected,vis,i);
            }
        }

        return ct;
    }
}