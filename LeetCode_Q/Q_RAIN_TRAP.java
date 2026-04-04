// Trapping Rain Water.


class Solution {
    public static int mini(int[] height, int idx){
        int m=0;
        for(int i=idx;i<height.length;i++){
            if(height[i]>m){
                m=height[i];
            }
        }
        return m;
    }


    public static void R_max(int[] height, int[] right_max_arr){
        for(int i=0;i<height.length;i++){
            right_max_arr[i]=mini(height,i);
        }
    }

    public static void L_max(int[] height,int[] left_max_arr){
        for(int i=0;i<height.length;i++){
            if(i==0){
                left_max_arr[i]=height[i];
            }
            else if(height[i]<left_max_arr[(i-1)]){
                left_max_arr[i]=left_max_arr[(i-1)];
            }
            else{
                left_max_arr[i]=height[i];
            }
        }

    }



    public int trap(int[] height) {
        int[] left_max_arr=new int[height.length];
        L_max(height,left_max_arr);
        int[] right_max_arr=new int[height.length];
        R_max(height,right_max_arr);
        int s=0;
        for(int i=0;i<height.length;i++){
            s+=((Math.min(left_max_arr[i],right_max_arr[i]))-height[i]);
        }
        return s;
    }
}