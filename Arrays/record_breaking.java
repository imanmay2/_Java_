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
   public static boolean check(int arr[],int num,int n,int idx){
    int f=0;
    for(int i=0;i<idx;++i){
        if(arr[i]<num){
            f++;
        }
        
    }
    if(f==idx){
        return true;
    }
    return false;
   }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        //inserting elements into an array.
        for(int i=0;i<n;++i){
            System.out.println("Enter the element : ");
            arr[i]=sc.nextInt();// array created
        }


        // main algo starts from here.
        // [1,2,0,7,2,0,2,2]
        int f=0;
        for(int i=0;i<n;i++){
            if(i==0 && arr[i]>arr[i+1]){
                System.out.println("RECORD BREAKING DAY : "+arr[i]);
                f=1;
            }
            else if(i==n-1 && check(arr,arr[i],n,i)==true){
                System.out.println("RECORD BREAKING DAY : "+arr[i]);
                f=1;
            }
            else if(check(arr,arr[i],n,i)==true && arr[i]>arr[i+1]){
                System.out.println("RECORD BREAKING DAY  : "+arr[i]);
                f=1;
            }
        }
        if(f==0){
            System.out.println("NO RECORD BREAKING DAY FOUND !!");
        }
    }
} 