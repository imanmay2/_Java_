import java.util.*;

public class Array_2{

    public static boolean question1(int arr[]){
        Arrays.sort(arr); 
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the element: ");
            arr[i]=sc.nextInt();
        }
        System.out.println(question1(arr));
    }
}