// Given an integer array nums, return all the triplets [nums[i], nums[j],
// nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0


public class zer0_triplet{
    public static void main(String args[]){
        int[] arr={-1, 0, 1, 2,-1,-4};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if((i!=j) && (j!=k) && (i!=k) && (arr[i]+arr[j]+arr[k]==0)){
                        System.out.print(arr[i]+","+arr[j]+","+arr[k]);
                    }
                }
                System.out.println();
            }
        }
    }
}