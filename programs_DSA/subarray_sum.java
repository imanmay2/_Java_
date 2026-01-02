// Given an array a[] of size n. Output sum of each subarray of the given array.


import java.util.*;
public class subarray_sum{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array  : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }



        //main algo starts from here.
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
            }
        }
        System.out.println("The sum of all the subarrays : "+ sum);
    }
}