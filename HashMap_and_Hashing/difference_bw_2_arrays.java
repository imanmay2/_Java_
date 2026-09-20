class Solution {
    public void insertset(int arr[],HashSet<Integer> hs){
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
    }

    public void check(HashSet<Integer> hs_t,HashSet<Integer> hs,List<Integer> list){
        for(int x:hs_t){
            if(!hs.contains(x)){
                list.add(x);
            }
        }
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //using the concept for hashset. 
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();

        insertset(nums1,hs1);
        insertset(nums2,hs2);

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        List<Integer> li2=new ArrayList<>();
        check(hs1,hs2,li1);
        check(hs2,hs1,li2);

        ans.add(li1);
        ans.add(li2);

        return ans;
    }
}