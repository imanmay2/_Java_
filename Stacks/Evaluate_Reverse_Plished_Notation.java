class Solution {
    public int evalRPN(String[] tokens) {
        //solving this Question using stack
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String item=tokens[i];
            try{
                //no error means its a number.
                int num=Integer.parseInt(item);
                st.push(num);
            }catch(Exception e){
                //it's a operator.
                int a=st.pop();
                int b=st.pop();
                if(item.equals("+")){
                    st.push(b+a);
                } else if(item.equals("-")){
                    st.push(b-a);
                }else if(item.equals("*")){
                    st.push(b*a);
                }else if(item.equals("/")){
                    st.push((int)b/a);
                }
            }
        }
        return st.pop();
    }
}