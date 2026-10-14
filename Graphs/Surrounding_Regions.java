class Solution {
    public void dfs(char board[][],int row,int col,boolean vis[][]){
        // it will traverse boundaries if containing O and it's connected O to #.
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!='O' || vis[row][col]){
            return;
        }

        vis[row][col]=true;
        //mark it as safe sequence
        board[row][col]='#';
        
        //check for any other O if connected from boundary and mark it as safe.
        dfs(board,row+1,col,vis);
        dfs(board,row,col+1,vis);
        dfs(board,row-1,col,vis);
        dfs(board,row,col-1,vis);
    }
    public void solve(char[][] board) {
        //traverse from boundaries and check. 

        //edge condition if only boundaries are present then no need to check for O as output will be same.
        if(board.length==1 || board[0].length==1){
            return;
        }

        boolean vis[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            dfs(board,i,0,vis);
            dfs(board,i,board[0].length-1,vis);
        }

        for(int j=0;j<board[0].length;j++){
            dfs(board,0,j,vis);
            dfs(board,board.length-1,j,vis);

        }

        // now if there is any O in boundary and on its connected , then it has been already marked as #.

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}