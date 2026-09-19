import java.util.Arrays;
import java.util.Scanner;

public class Inbuilt_Sort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter the number: ");
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Sorted array: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
