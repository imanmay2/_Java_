import java.util.Scanner;
import java.util.Stack;
public class duplicateParenthesis{

    public static boolean duplicateParenthesis_(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                int ct=0;
                while(!(s.peek()=='(')){
                    ct++;
                    s.pop();
                }
                if(ct<1){
                    return true;   //duplicate found.
                }
                s.pop();
            } else{
                s.push(str.charAt(i));
            }
        }
        if(s.isEmpty()){
            return false;  // No duplicate
        }
        return true;  //Having duplicate.
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if(duplicateParenthesis_(str)){
            System.out.println("String is having duplicate parenthesis.");
        } else{
            System.out.println("String is not having duplicate parenthesis.");
        }
    }
}