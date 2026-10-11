class Solution {

    //use the concept of Next Greater Element to find the next smaller left and next smaller right and find the max area. 
    public void nsl(int heights[],int sl[]){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                sl[i]=-1;
            }else{
                sl[i]=st.peek();
            }
            st.push(i);
        }
    }

    public void nsr(int heights[],int sr[]){
        Stack<Integer> st=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                sr[i]=heights.length;
            }else{
                sr[i]=st.peek();
            }
            st.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int sl[]=new int[heights.length];
        int sr[]=new int[heights.length];

        nsl(heights,sl);
        nsr(heights,sr);

        int maxArea=-1;
        for(int i=0;i<heights.length;i++){
            maxArea=Math.max(maxArea,heights[i]*(sr[i]-sl[i]-1));
        }return maxArea;
    }
}