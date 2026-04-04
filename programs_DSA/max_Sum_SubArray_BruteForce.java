import java.util.Scanner;

public class max_Sum_SubArray_BruteForce {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] arr = { 1, -2, 6, -1, 3 };
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println("Max_sum_subarray is: " + max);
    }
}
