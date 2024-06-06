// Q is in the notes DSA copy..kindly refer that manmay.


import java.util.*;
public class trap_rainwater{
    public static int max_L(int[] arr,int[] left_max_arr){
        for(int i=0;i<arr.length;i++){
            if(i==0){
                left_max_arr[i]=arr[i];
            }
            else if(arr[i]<left_max_arr[(i-1)]){
                left_max_arr[i]=arr[i];
            }
        }
    }


    public static int max_R(int[] arr, int[] right_max_arr){
        
    }





    //main algo func
    public static int rain_trap(int[] arr,int width){
        int[] left_max_arr=new int[arr.length];
        int[] right_max_arr=new int[arr.length];
        max_L(arr,left_max_arr);


    }



    public static void main(String args[]){
        int[] arr={4,2,0,6,3,2,5};
        int width=1;
    }
}