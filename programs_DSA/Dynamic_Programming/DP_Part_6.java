public class DP_Part_6 {

    public static void init_dp(int[] dp){
        for(int i=0;i<dp.length-1;i++){
            dp[i]=-1;
        }
        dp[dp.length-1]=0; //init
    }

    public static int canJump(int[] nums) {
        int dp[]=new int[nums.length];
        init_dp(dp);
        int n=dp.length;
        for(int i=n-2;i>=0;i--){
            int ans=Integer.MAX_VALUE;
            int steps=nums[i];
            for(int j=i+1;j<=i+steps && j<n;j++){
                if(dp[j]!=-1){
                    ans=Math.min(ans,dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }return dp[0];
    }

    public static int maxPartition(int arr[]){
        
    }


    
    public static void main(String args[]){
        System.out.println("Welcome to Java. ");
        int arr[]={2,3,1,1,4};

       System.out.println(canJump(arr));
    }
}