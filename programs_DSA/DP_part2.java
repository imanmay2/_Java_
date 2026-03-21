public class DP_part2{
    public static int knapSack_Recursion(int val[],int wt[],int n,int w){
        if(n==0 || w==0){
            return 0;
        }
        if(wt[n-1]<=w){
            //valid case
            int ans1=val[n-1]+knapSack_Recursion(val, wt, n-1, w-wt[n-1]);
            int ans2=knapSack_Recursion(val, wt, n-1, w);

            return Math.max(ans1,ans2);
        }else{
            //invalid case
            int ans=knapSack_Recursion(val, wt, n-1, w);
            return ans;
        }
    }

    public static int knapSack_Memo(int val[],int wt[],int n,int w,int dp[][]){
        if(n==0 || w==0){
            //base case
            return 0;
        }
         if(dp[n][w]!=-1){
            return dp[n][w];
        } if(wt[n-1]<=w){
            //valid 
            int ans1=val[n-1]+knapSack_Memo(val, wt, n-1, w-wt[n-1], dp);
            int ans2=knapSack_Memo(val, wt, n-1, w, dp);
            dp[n][w]=Math.max(ans1,ans2);
            return dp[n][w];
        } else{
            dp[n][w]=knapSack_Memo(val, wt, n-1, w, dp);
            return dp[n][w];
        }
    }
    public static void init(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
    }
    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        System.out.println(knapSack_Recursion(val, wt, val.length, 7));
        int dp[][]=new int[val.length+1][w+1];
        init(dp);
        System.out.println(knapSack_Memo(val, wt,val.length, w,dp));
    }
}