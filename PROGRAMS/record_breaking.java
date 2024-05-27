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
   

    public static void main(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        //inserting elements into an array.
        for(int i=0;i<n;++i){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();// array created
        }


        //main algo starts from here.

    }
} 