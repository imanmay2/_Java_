// Given an array. Sort it via BUBBLE SORT METHod.


import java.util.*;
public class SORTING{
    public static void bubble_sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<(arr.length-i)-1;j++){
                if(arr[j]>arr[j+1]){
                     int temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                }
            }
        }
    }


    public static void selection_sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int mini=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[mini]>arr[j]){
                    mini=j;
                }
            }
            int temp=arr[mini];
            arr[mini]=arr[i];
            arr[i]=temp;
        }
    }


    public static void insertion_sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }

            //insertion
            arr[prev+1]=curr;
        }
    }


    public static void main(String args[]){
        Integer[] arr={8,1,7,2,6,3,5};
        Arrays.sort(arr); 


        //sorting in a range...
        Arrays.sort(arr,0,3);

        // sorting in ascending order.
        Arrays.sort(arr,Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    } 
}