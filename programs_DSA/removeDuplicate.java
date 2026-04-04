public class removeDuplicate {
    public static boolean check(String s,String str){
        for(int i=0;i<str.length();i++){
            if(s.equals(str.charAt(i)+"")){
                return true;
            }
        }
        return false;
    }


    public static int removeDuplicates(int[] nums) {
        String str=",";
        for(int i=0;i<nums.length;i++){
            String s=Integer.toString(nums[i]);
            if(!check(s,str)){
                str+=s;
            }
        }

        return str.length()-1;
    }
    public static void main(String args[]){
        int[] arr_={1,1,1,2};
        // System.out.println(removeDuplicates(new int[]{1,1,1,2}));
        System.out.println(removeDuplicates(arr_));
    }
}
