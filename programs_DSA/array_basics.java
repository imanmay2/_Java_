import java.util.*;
public class array_basics{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total range of the array : ");
        n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<=n-1;i++){
            System.out.print("Enter the Element : ");
            arr[i]=sc.nextInt();
        }



    //displaying the arr's element .

        System.out.println("The elements in the array are : ");
        for(int j=0;j<=n-1;j++){
            System.out.print(arr[j]+",");
        }
    }
    
}