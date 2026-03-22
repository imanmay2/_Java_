public class DP_Part3 {
    public static int LCS_Recursion(String str1,String str2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            //1st case if the last character of the string is equal
            return 1+ LCS_Recursion(str1, str2, n-1, m-1);
        }else{
            return Math.max(LCS_Recursion(str1, str2, n-1, m), LCS_Recursion(str1, str2, n, m-1));
        }
    }

    public static void init_Memoiation(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
    }

    public static int LCS_Memoization(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
         if(str1.charAt(n-1)==str2.charAt(m-1)){
            //1st case if the last character of the string is equal
            dp[n][m]=1+ LCS_Memoization(str1, str2, n-1, m-1,dp);
            return dp[n][m];
        }else{
            dp[n][m]= Math.max(LCS_Memoization(str1, str2, n-1, m,dp), LCS_Memoization(str1, str2, n, m-1,dp));
            return dp[n][m];
        }
    }

    

    public static int LCS_Tabulation(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];

        //initialization 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    //match found
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }return dp[n][m];
    }
    public static void main(String args[]){
        String str1=new String("abcde");
        String str2=new String("acde");
        System.out.println(LCS_Recursion(str1, str2, str1.length(), str2.length()));
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        init_Memoiation(dp);
        System.out.println("LCS_Memo : "+LCS_Memoization(str1, str2, str1.length(), str2.length(), dp));
        System.out.println("LCS Tab : "+LCS_Tabulation(str1, str2));
    }
}
