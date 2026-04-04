public class unique_array_num {
 public static void main(String args[]) {
   int[] nums={1,1,2,2,3};
    int k=0;
    for(int i=0;i<nums.length;i++){
      int ct=0;
      for(int j=i+1;j<nums.length;j++){
        if(nums[i]==nums[j]){
          ct++;
          }
        
      }
      if(ct==0){
        k++;
      }
    }
    System.out.print(k);
 }
}