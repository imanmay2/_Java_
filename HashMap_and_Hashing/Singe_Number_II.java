class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }

        //iterate through the hashmap. 
        for(Integer key:hm.keySet()){
            if(hm.get(key)==1){
                return key;
            }
        }
        return -1;
    }
}