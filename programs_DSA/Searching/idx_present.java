//  WAP that will create an array and also accept an element
// and find whether it is present or not in the array, if present return the index value.

import java.util.*;
public class idx_present{
    public static void check_ele(int arr[],int ele){
        int f=0;
        for(int i=0;i<arr.length;i++){
            if(ele==arr[i]){
                f=1;
                System.out.println("Matching element found at index "+i);
                break;
            }
        }
        if(f==0){
            System.out.println("No matching element found!!!!");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array  : ");
        int n=sc.nextInt();
        int[] arr=new int[n];   //array created
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }
        //main algo starts from here.
        System.out.println("Enter the element you are searching at : ");
        int num=sc.nextInt();
        check_ele(arr,num);
    }
}