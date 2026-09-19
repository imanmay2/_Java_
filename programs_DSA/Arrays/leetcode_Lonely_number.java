import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_Lonely_number {
    public static List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list_lonely=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==0 && (nums[i]!=nums[i+1] && nums[i]+1!=nums[i+1])){
                list_lonely.add(nums[i]);
            }
            else if(i==nums.length-1 && (nums[i-1]!=nums[i] && nums[i-1]!=nums[i]-1)){
                list_lonely.add(nums[i]);
            }
            else if((i!=nums.length-1)?(nums[i]!=nums[i+1] && nums[i]+1!=nums[i+1] && nums[i]!=nums[i-1] && nums[i-1]!=nums[i]-1):false){
                list_lonely.add(nums[i]);
            }
        }
        return list_lonely;
    }
    public static void main(String args[]){
        int[] nums={69,45,69};
        System.out.println(findLonely(nums));
    }
}
