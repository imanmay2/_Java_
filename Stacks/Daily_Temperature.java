class Solution {
    class Info{
        int n,idx;
        public Info(int n,int idx){
            this.n=n;
            this.idx=idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        //concept is same as Next Greater Element 
        Stack<Info> st=new Stack<>();
        int n=temperatures.length;
        int res[]=new int[n];

        for(int i=n-1;i>=0;i--){
            int curr=temperatures[i];
            while(!st.isEmpty() && curr>=st.peek().n){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=0;
            }else{
                res[i]=st.peek().idx-i;
            }

            st.push(new Info(curr,i));
        }return res;
    }
}