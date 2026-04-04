// Write a program that will find the pair of the given sum in the ARAAY.


import java.util.*;
public class pair_sum{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }

        //main algo starts from here.
        System.out.println("Enter the sum : ");
        int s=sc.nextInt();
        boolean f=false;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==s){
                    System.out.println("Pair found!! "+arr[i]+","+arr[j]);
                    f=true;
                }
            }
        }
        if(f==false){
            System.out.println("No pair found !!!");
        }
    }
}