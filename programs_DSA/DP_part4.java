public class DP_part4 {
    public static int LongestCommonSubString(String str1,String str2){
        //using the tabulation technique to solve
        int n=str1.length();
        int m=str2.length();

        int dp[][]=new int[n+1][m+1];
        
        //init
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        int ans=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }return ans;
    }
    public static void main(String args[]) {
        System.out.println("Longest Common SubString is. : "+LongestCommonSubString("ABCDE", "ABGCE"));
    }
}
