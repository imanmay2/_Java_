class Solution {

    class Info{
        int row,col,step;
        public Info(int row,int col,int step){
            this.row=row;
            this.col=col;
            this.step=step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        //Use BFS to solve this problem.
        boolean vis[][]=new boolean[mat.length][mat[0].length];
        int dist[][]=new int[mat.length][mat[0].length];
        Queue<Info> q1=new LinkedList();

        //step1 : store all those 0 in the quueue, with step count 0. 
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q1.add(new Info(i,j,0));
                    // vis[i][j]=true;
                }
            }
        }

        int dirR[]={-1,1,0,0};
        int dirC[]={0,0,-1,1};
        //perform bfs.
        while(!q1.isEmpty()){
            Info curr=q1.remove();
            int row=curr.row;
            int col=curr.col;
            if(!vis[row][col]){
            vis[row][col]=true;
            int step=curr.step;
            dist[row][col]=step; //store in the distance array. 

            //traverse through the neighbours and vis or not.
            for(int i=0;i<4;i++){
                int nrow=row+dirR[i];
                int ncol=col+dirC[i];
                if(nrow<0 || ncol<0 || nrow>=mat.length || ncol>=mat[0].length){
                    continue;
                }
                if(!vis[nrow][ncol]){
                    q1.add(new Info(nrow,ncol,step+1));
                }
            }
            }
        }return dist;
    }
}