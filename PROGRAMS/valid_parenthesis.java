import java.util.*;
public class valid_parenthesis {
    public static void check_parenthesis(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'  || s.charAt(i)=='}' || s.charAt(i)==']'){
                char ch=s.charAt(i);
                if(st.isEmpty()){
                    System.out.println("Invalid!!! Parenthesis!!!!");
                }
                else if((ch==')' && st.peek()=='(') || (ch=='}' && st.peek()=='{') || (ch==']' && st.peek()=='[')){
                    st.pop();
                }
                else{
                    System.out.println("Invalid Parenthesis ");
                    return;
                }
            }
        }
        if(s.isEmpty()){
            System.out.println("Valid Parenthesis !!");
            return;
        }
        else{
            System.out.println(st);
            System.out.println("InValid Parenthesis !!!!");
        }

    }
   public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the String : ");
    String s=sc.nextLine();
    check_parenthesis(s);
   }
}
