import java.util.*;
public class leetcode_testcase {
    public static boolean check(int arr[],int k){
        int f=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k){
                f++;
            }
        }
        if(f>1){
            return false;
        }
        else {
            return true;
        }
    }
    public static int[] singleNumber(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int f=0;
       for(int i=0;i<nums.length;i++){
        if(check(nums,nums[i])){
            arr[f]=nums[i];
            f++;
        }
       }
       return arr; 
    }

    public static void main(String args[]){
        int[] arr=new int[6];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(singleNumber(arr));
    }
}