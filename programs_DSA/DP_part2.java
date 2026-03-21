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


    public static int knapSack_Tab(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        //initialization
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int w=wt[i-1];
                int v=val[i-1];
                if(w<=j){
                    //valid condition
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        } return dp[n][W];
    }

    public static void init_TargetSumDP(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
    }

    public static boolean targetSumTabulation(int arr[],int targetSum){
        boolean dp[][]=new boolean[arr.length+1][targetSum+1];
        init_TargetSumDP(dp);
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]){
                    dp[i][j]=true;
                }else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        } return dp[arr.length][targetSum];
    }

    
    public static void main(String args[]){
        // int val[]={15,14,10,45,30};
        // int wt[]={2,5,1,3,4};
        // int w=7;
        // System.out.println(knapSack_Recursion(val, wt, val.length, 7));
        // int dp[][]=new int[val.length+1][w+1];
        // init(dp);
        // System.out.println(knapSack_Memo(val, wt,val.length, w,dp));

        // System.out.println("Tabulation Format : "+knapSack_Tab(val, wt, 7));

        int arr[]={4,2,7,1,3};
        System.out.println("TargetSum : "+ targetSumTabulation(arr, 10));
    }
}