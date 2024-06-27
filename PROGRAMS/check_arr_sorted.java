// WAP that will check whther the given array is sorted or not...




import java.util.*;
public class check_arr_sorted{
    public static boolean check(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        else if(arr[i]>arr[i+1]){
            return false;
        }

        return check(arr,i+1);

    }



    public static void main(String args[]){
        int[] arr={1,2,5,4};
        System.out.print(check(arr,0));
    }
}