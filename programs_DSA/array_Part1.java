package Practise;
import java.util.Scanner;

public class array_Part1{

    public static void BubbleSort(int n,int[] arr){
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }


    public static void inputArr(int n,int[] arr){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.print("Enter the element: ");
            arr[i]=sc.nextInt();
        }
        System.out.println();
    }


    public static void printArr(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void linearSearch(int n,int[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the key value : ");
        int k=sc.nextInt();
        boolean f=false;
        for(int i=0;i<n;i++){
            if(arr[i]==k){
                System.out.print("Key Found! at position : "+i+1);
                f=true;
                break;
            }
        }
        if(f==false){
            System.out.println("Key not found in the Array!");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the range of the array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];

        inputArr(n, arr);

        binarySearch(n, arr);
        printArr(n, arr);
    }
}