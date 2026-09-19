// Smallest positive missing number .
// Accoute,Amazon,Samsung,Snapdeal
// You are given an array arr[] of N integres including 0. the task is to find the smallest
// positive number missing from the array.
// e.g : [0,-9,1,3,-4,5]
// Hence, the first positive missing number is 2.


import java.util.*;
public class positive_missing{
    public static boolean check(int n,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(n==arr[i]){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element  : ");
            arr[i]=sc.nextInt();
        }
        //main algo starts from here.
        int p=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                p=arr[i];
            }
            if(check((p+1),arr)==false){
                System.out.println("Smallest missing number is : "+(p+1));
                break;
            }

        }
    }
}
