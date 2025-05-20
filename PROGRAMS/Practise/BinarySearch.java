import java.util.Scanner;


//Implement Binary Search.
public class BinarySearch{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);


        //input array.
        System.out.println("Enter the length of the array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];    

        for(int i=0;i<n;i++){
            System.out.print("Enter the number : ");
            arr[i]=sc.nextInt();
        }

        System.out.println();


        int start=0;
        int end=arr.length-1;

        
        System.out.print("Enter the key to be serached for: ");
       int key=sc.nextInt();
       boolean found=false;
       while(start<=end){
        int mid=(start+end)/2;
        // Arr-->   [2,4,6,8,10]   
        if(arr[mid]==key){
            System.out.println("Key found at Index: "+mid);
            found=true;
            break;
        } else if(arr[mid]>key){
            end=mid-1;
        } else{
            start=mid+1;
        }
       }

       if(found==false){
        System.out.println("Key not found in the array.");
       }
    }
}