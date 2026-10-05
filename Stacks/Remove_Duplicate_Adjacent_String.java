class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                while(!st.isEmpty() && st.peek()==s.charAt(i)){
                    st.pop();
                }
                continue;
            }else{
                st.push(s.charAt(i));
            }
        }

        //pop elements into a stringbuilder
        StringBuilder sb=new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();
        return sb.toString();
    }
}