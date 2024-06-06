// WAP that will  return the maximum sum of the subarray.


import java.util.*;
public class max_sum_subarray{
    public static int max_sum(int[] arr){
        int sum=0,s=0;
        for(int i=0;i<arr.length;i++){
            s=0;
            for(int j=i;j<arr.length;++j){
                s=s+arr[j];
            }
            if(s>sum){
                sum=s;
            }
        }
        return sum;
    }


    public static void main(String args[]){
        int[] arr={2,4,6,8,10};
        System.out.println("The maximum value of the subarray is: "+max_sum(arr));
    }
}



                            // Prefix Sum method to calculate the max sum of the subarray.

import java.util.*;
public class max_sum_subarray{
    public static int max_sum(int[] arr){
        int sum=0,s=0;
        int[] pre_arr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
            pre_arr[i]=s;
        }
        return pre_arr[(arr.length-1)];
    }



    public static void main(String args[]){
        int[] arr={2,4,6,8,10};
        System.out.println("The max sum of the array : "+max_sum(arr));
    }
}