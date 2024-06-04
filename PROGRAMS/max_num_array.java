// find the maximum number from the lists of given given in the array.



import java.util.*;
public class max_num_array{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array  : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();
        }


        //main algo starts from here.

        int maxi=0;
        for(int i=0;i<arr.length;i++){
            if(maxi<arr[i]){
                maxi=arr[i];
            }
        }
        System.out.println("The maximum element from the array : "+maxi);
    }
}