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
        int[] arr={1,-2,6,-1,3};
        System.out.println("The maximum value of the subarray is: "+max_sum(arr));
    }
}





//                  kadane's algorithm 



public class max_sum_subarray{
    public static int max_sum(int[] arr){
        int s=0,sum=0;
        int[] pre_arr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
            if(s<0){
                s=0;
                sum=0;
            }
            else if(s>sum){
                sum=s;
            }
        }
        return sum;
    }



    public static void main(String args[]){
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        System.out.println("The maximum subarray : "+max_sum(arr));
    }
}