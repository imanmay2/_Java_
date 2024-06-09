import java.util.*;
public class missing_number{
    public static void main(String args[]){
        int[] nums={3,0,1};
        Arrays.sort(nums);
        System.out.println("Sorted Array is : ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();


        for(int i=0;i<nums.length;i++){
            if(nums[i]+1!=nums[i+1]){
                System.out.println((nums[i]+1));
                break;
            }
        }
    }
}