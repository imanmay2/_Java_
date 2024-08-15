import java.util.*;
public class duplicate_parenthesis {
    public static boolean duplicate_Parenthesis(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                int ct=0;
                while(st.peek()!='('){
                    ct++;
                    st.pop();
                }
                if(ct<1){
                    st.pop();
                    return true;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        return false;
        

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s=sc.nextLine();
        if(duplicate_Parenthesis(s)){
            System.out.println("Duplicate Parenthesis is present!!!");

        }
        else{
            System.out.println("Duplicate Parenthesis not present!!!");
        }


    }
}
