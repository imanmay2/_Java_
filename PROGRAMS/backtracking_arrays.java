// Apply Backtracking on arrays...


import java.util.*;
public class backtracking_arrays{
    public static void backtrack(int arr[],int i,int val){
        //base case
        if(arr.length==i){
            print_Arr(arr);
            return;
        }
        arr[i]=val;
        backtrack(arr,i+1,val+1);
        arr[i]=arr[i]-2;
    }



    public static void print_Arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }




    public static void main(String args[]){
        int arr[]=new int[5];
        backtrack(arr,0,1);
        print_Arr(arr);
    }
}