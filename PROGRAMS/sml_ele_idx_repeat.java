// Given an array arr[] of size N. The task is to find the first repeating element in the array of integres. i.e an
//element that occurs more than once and whose index of the first occurence is smallest.
//	E.g : [1,5,3,4,3,5,6]
//	 output : 2               (FACEBOOK , AMAZON )


import java.util.*;
public class sml_ele_idx_repeat{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n]; // creating array
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();// inserting element in the array.
        }


        //main algo starts here....
        boolean f=false;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    System.out.println("Smallest repeating element found at index : "+(i+1));
                    f=true;
                    break;
                }
                if(f==true){
                    break;
                }
            }
            }
            if(f==false){
                System.out.println("No repeating element found !!!");
            }
        }
}
