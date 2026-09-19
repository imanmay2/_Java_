import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && i==0){
                return nums[i]-1;
            }
            else if(i==nums.length-1){
                return nums[i]+1;
            }
            else if(nums[i+1]!=nums[i]+1){
                return nums[i]+1;
            }

        }
        return 0;
    }
}