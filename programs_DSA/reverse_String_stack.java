import java.util.*;
public class reverse_String_stack {
    public static String reverse_String(String str){
        int i=0;
        Stack<Character> s=new Stack<>();
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        String str_="";
        while(!s.isEmpty()){
            str_=str_+s.pop();
        }
        return str_;
    }
    public static void main(String args[]){
        String str="abcd";
        System.out.println(reverse_String(str));
    }
}
