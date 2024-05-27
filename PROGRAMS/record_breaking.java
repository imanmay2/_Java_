// Record breaking day.
// [1,2,0,7,2,0,2,2]
// conditions to be noted is that : 
// the number of visitors on that day is strictly larger than the number 
// of visitors on each of the previous days.
// Either it is the last day, or the number of visitors on the day is strictly larger than the number of visitors 
// on the following day.
// NOTE : every first day could be record breaking days.


import java.util.*;
public class record_breaking{
    static boolean check(int arr[],n){

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();// inserting elements into the array..
        }
        

        //main algo starts from here.
        for(int i=0;i<=n-2;i++){
            if(i=0 && arr[i]>arr[i+1]){
                System.out.println(arr[i]+"is a record breaking day ");
            }
            else if(i==n-2 && arr[i]>arr[i+1]){
                System.out.println(arr[i]+"is a record breaking day");
            }
        }
    }
}