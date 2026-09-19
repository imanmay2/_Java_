import java.util.*;

public class DP_part_1{
    public static int fibonacci(int n){
        //inefficient one . T.C => O(2^n)

        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    // n=8;
    // 0,1,1,2,3,5,8,13,21 
    public static int fiboMemomization(int n,int dp[]){
        //store the elements in the array if already being stored. 
        if(n==0 || n==1){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n]=fiboMemomization(n-1, dp)+fiboMemomization(n-2, dp);
        return dp[n];
    }

    public static int fiboTabulation(int n){
        int dp[]=new int[n+1];
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static int knapSack(int val[],int wt[],int n,int w){
        if(n==0 || w==0){
            return 0;
        }

        if(wt[n-1]<=w){
            //2 choices

            //include
            int ans1=val[n-1]+knapSack(val, wt, n-1, w-wt[n-1]);
            //exclude
            int ans2=knapSack(val,wt,n-1,w);

            return Math.max(ans1, ans2);
        } else{
            return knapSack(val, wt, n-1, w);
        }
    }

    public static int knapSack_Memo(int val[],int wt[],int n,int w,int dp[][]){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(wt[n-1]<=w){
            //valid--> 2 choices
            int ans1=val[n-1]+knapSack_Memo(val, wt, n-1, w-wt[n-1],dp);
            int ans2=knapSack_Memo(val, wt, n-1, w,dp);
            dp[n][w]=Math.max(ans1, ans2);
            return dp[n][w];
        }else{
            dp[n][w]=knapSack_Memo(val, wt, n-1, w,dp);
            return dp[n][w];
        }
    }



    public static void main(String args[]){
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter the number : ");
        // int n=sc.nextInt();
        // System.out.println(fibonacci(n));
        
        // // int dp[]=new int[n+1];
        // System.out.println("Fibonacci Memomization is : "+fiboMemomization(n, dp));

        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int dp[][]=new int[val.length+1][7+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapSack(val, wt, val.length,7));
        System.out.println("knap_sack_memo: "+knapSack_Memo(val, wt, val.length, 7, dp));
    }
}