import java.util.*;

public class Greedy_Algorithm {
    public static int ActivitySelection(int start[], int end[]) {
        int ct = 1;
        int idx = 0; // prev choosen idx
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= end[idx]) {
                ct++;
                idx = i;
            }
        }
        return ct;
    }

    public static int fractional_knapsack(int val[], int wt[], int W) {
        double ratio[] = new double[val.length];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = val[i] / (double)wt[i];
        }

        // sort in descending order.
        double arr[][] = new double[ratio.length][2];
        for (int i = 0; i < ratio.length; i++) {
            arr[i][0] = i;
            arr[i][1] = ratio[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        int maxProfit = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int)arr[i][0];

            if (W >= wt[idx]) {
                maxProfit += val[idx];
                W = W - wt[idx];
            }else{
                maxProfit+=ratio[idx]*W;
                W=0;
            }
        }
        return maxProfit;
    }

    public static int min_abs_diff_pairs(int arr1[],int arr2[]){
        int mini=0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            mini+=Math.abs(arr1[i]-arr2[i]);
        }
        return mini;
    } 

    public static void main(String args[]) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        // // System.out.println(ActivitySelection(start, end));

        // int val[]={60,100,120};
        // int wt[]={10,20,30};
        // int W=50;
        // System.out.println(fractional_knapsack(val, wt, W));

        int arr1[]={1,2,3};
        int arr2[]={3,2,1};
        System.out.println(min_abs_diff_pairs(arr1, arr2));
    }
}