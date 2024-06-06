// WAP that will print the area of the RAIN TRAPPED in the bar diagram of the array.



import java.util.*;
public class trap_rainwater{
    public static int maxi_range(int[] arr,int idx){
        int m=0;
        for(int i=idx;i<arr.length;i++){
            if(arr[i]>m){
                m=arr[i];
            }
        }
        return m;
    }



    public static void R_max_arr(int[] arr,int[] right_max_arr){
        for(int i=0;i<arr.length;i++){
            right_max_arr[i]=maxi_range(arr,i);
        }
    }




    public static void L_max_arr(int[] arr, int[] left_max_arr){
        for(int i=0;i<arr.length;i++){
            if(i==0){
                left_max_arr[i]=arr[i];
            }
            else if(arr[i]<left_max_arr[(i-1)]){
                left_max_arr[i]=left_max_arr[(i-1)];
            }
            else{
                left_max_arr[i]=arr[i];
            }
        }
    }



    public static void main(String args[]){
        int[] arr={4,2,0,3,2,5};
        int[] left_max_arr=new int[arr.length];
        L_max_arr(arr,left_max_arr);
        int[] right_max_arr=new int[arr.length];
        R_max_arr(arr,right_max_arr);

        // formula ....
        int s=0;
        int width=1;
        for(int i=0;i<arr.length;i++){
            s+=(((Math.min(right_max_arr[i],left_max_arr[i]))-arr[i])*width);
        }


        System.out.print("The Area of the rain trapped is : "+ s);    
    }
}