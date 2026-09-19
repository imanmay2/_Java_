public class DP_Part_5{

    //catalan's number

    public static int Catalan_Rec(int n){
        if(n==0 || n==1){
            return 1;
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Catalan_Rec(i)*Catalan_Rec(n-i-1);
        } return ans;
    }

    public static void init_memo_Catalan(int dp[]){
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
    }
    public static int Catalan_Memo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Catalan_Memo(i, dp)*Catalan_Memo(n-i-1, dp);
        }return ans;
    }


    public static int Catalan_Tab(int n){
        //init
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }return dp[n];
    }
    public static void main(String args[]){
        // System.out.println("Catalan Recursion is : "+Catalan_Rec(5));
        int n=5;
        int dp[]=new int[n+1];
        init_memo_Catalan(dp);
        System.out.println("Memoization of the Catalan is : "+Catalan_Memo(n, dp));

        System.out.println("Tabulation Catalan is : "+Catalan_Tab(n));
    }
}
