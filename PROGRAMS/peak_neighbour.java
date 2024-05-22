 /* 5 .Find a peak element which is not smaller than its neighbours
Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing, find the maximum element in the array.

Note: If the array is increasing then just print the last element will be the maximum value.

Example:

Input: array[]= {5, 10, 20, 15}
Output: 20
Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20. */



import java.util.*;
public class peak_neighbour{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];   // create an array of size n;
        for(int i=0;i<n;i++){
            System.out.println("Enter the element  : ");
            arr[i]=sc.nextInt();
        }


        // main algo starts from here.    [1,2,3,4]
        for(int i=0;i<=n-1;i++){
            if(i==0 && arr[i]>arr[i+1]){
                System.out.println("Peak Element is : "+arr[i]);
            }
            else if(i==n-1 && arr[i]>arr[i-1]){
                System.out.println("Peak Element is : "+arr[i]);
            }
            else if(arr[i]>arr[i+1] && arr[i]>arr[i-1]){
                System.out.println("Peak Element is : "+arr[i]);
            }
            
        }
    }
}