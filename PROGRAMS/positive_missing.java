// Smallest positive missing number .
//Accoute,Amazon,Samsung,Snapdeal
//You are given an array arr[] of N integres including 0. the task is to find the smallest
//positive number missing from the array.
//e.g : [0,-9,1,3,-4,5]
//Hence, the first positive missing number is 2.


import java.util.*;
public class positive_missing{
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
        boolean f=false;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                for(int j=i+1;j<n;j++){
                    if(arr[i]+1==arr[j]){
                        continue;
                }

            }
        }
    }
    if(f==false){
        System.out.println("Sorry !! Small positve missing number not found !!");
    }
}
}