import java.util.ArrayList;
import java.util.Scanner;

public class reverseAL {

    public static void printArr(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }

    public static void reverseArr(ArrayList<Integer> arr){
        int left=0;
        int right=arr.size()-1;
        while(left<right){
            int temp=arr.get(left);
            arr.set(left,arr.get(right));
            arr.set(right,temp);

            left++;
            right--;
        }
    }
    public  static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>();
        System.out.println("Enter the size of  the array: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter the element: ");
            int ele=sc.nextInt();
            arr.add(ele);
        }

        reverseArr(arr);
        printArr(arr);
    }
}
