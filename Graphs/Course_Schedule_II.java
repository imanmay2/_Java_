class Solution {

    //Overall  : check simulataneously that if the graph is cyclic or not , alogn with insert the last non-dependency element into stack ,if not cycle pop the elements and get the result, if cyclic thn return empty array.
    public boolean dfs(List<Integer> graph[],boolean vis[],Stack<Integer> st,boolean stack[],int curr){
        //push the element when there is no more dependency of that.
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(stack[neigh]){
                return true; //cycle exists
            }
            if(!vis[neigh] && dfs(graph,vis,st,stack,neigh)){
                return true;
            }
        }

        //push the element in the stack, as this element is last which doesn't has any dependency.
        st.push(curr);
        stack[curr]=false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //first convert it into Adjancancy list.
        List<Integer> graph[]=new ArrayList[numCourses];

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int pre=prerequisites[i][1];
            int course=prerequisites[i][0];
            graph[pre].add(course);
        }

        //use DFS based topological sorting. //use stack
        
        boolean vis[]=new boolean[numCourses];
        Stack<Integer> st=new Stack<>();
        //check for connected components
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(graph,vis,st,new boolean[numCourses],i)){
                    return new int[0];
                }
            }
        }

        int res[]=new int[numCourses];
        //pop the element from stack to get the order (Topological Sort).
        int k=0;
        while(!st.isEmpty()){
            res[k++]=st.pop();
        }
        return res;
    }
}