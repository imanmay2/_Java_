class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Approach is : think of the array twice like a circular array and do NGE in the 
        // assumption array.

        //DRY run the Code to get the feel of the approach. (VERY EASY QUESTION)


        Stack<Integer> st=new Stack<>();
        int arr[]=new int[nums.length];
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--){
            int curr=nums[i%n];
            //loop condition as we are assuming the array elements twice.
            while(!st.isEmpty() && curr>=st.peek()){
                st.pop();
            }

            if(i<n){
                if(st.isEmpty()){
                    arr[i]=-1;
                }else{
                    arr[i]=st.peek();
                }
            }
            st.push(curr);
        }
        return arr;
    }
}