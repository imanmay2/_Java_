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
    public static void main(String args[]){
        String str1=new String("abcde");
        String str2=new String("ace");
        System.out.println(LCS_Recursion(str1, str2, str1.length(), str2.length()));
    }
}
