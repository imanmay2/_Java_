import java.util.Arrays;
import java.util.Scanner;

public class Array {

    public static void printArr(int arr[],int n){
        System.out.println("Array is as follows : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array : ");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        printArr(arr, n);
    }
}
