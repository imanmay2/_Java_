import java.util.Arrays;
import java.util.HashSet;

public class DP_part4 {
    public static int LongestCommonSubString(String str1, String str2) {
        // using the tabulation technique to solve
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // init
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int LCS(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];

        // init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int lengthOfLIS(int[] nums) {
        // creating the unique sorted array
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int arr2[] = new int[hs.size()];
        int i = 0;
        for (int num : hs) {
            arr2[i++] = num;
        }

        Arrays.sort(arr2);

        return LCS(nums, arr2);
    }

    public static void main(String args[]) {
        System.out.println("Longest Common SubString is. : " + LongestCommonSubString("ABCDE", "ABGCE"));
    }
}
