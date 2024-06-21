public class trial{
    public static void main(String args[]){
        int[] nums={1,3,5,6};
        int s=0;
        int e=nums.length-1;
        int mid=(s+e)/2;
        int target=7;
        while(s<=e){
            mid=(s+e)/2;
            if(nums[mid]==target){
                System.out.println(mid);
                break;
            }
            else if(nums[mid]<target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        if(mid==nums.length-1)
        System.out.println(mid);
    }
}