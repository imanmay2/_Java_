import java.util.Stack;

public class reverseString_Stack {
    public static String reverseString(String str,Stack<Character> s){
        int i=0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }

        str=new String("");
        while(!s.isEmpty()){
            str=str+s.pop();
        }

        return str;
    }

    public static void main(String args[]){
        String str="Hello Java!";
        Stack<Character> s=new Stack<>();
        System.out.println(reverseString(str,s));
    }
}
