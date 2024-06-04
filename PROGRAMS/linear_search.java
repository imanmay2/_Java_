// Implement the algorithm for LINEAR SEARCH.

import java.util.*;
public class linear_search{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }



        // main algo starts from here.
        System.out.println("Enter the key : ");
        int num=sc.nextInt();
        boolean f=false;
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                System.out.println("Match Found!!! at index "+i);
                f=true;
                break;
            }
        }
        if(f==false){
            System.out.println("Element not found!!");
        }
    }
}