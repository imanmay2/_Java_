import java.util.Scanner;
import java.util.Stack;

public class validParenthesis {

    public static boolean validParenthesis_(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if ((str.charAt(i) == ')' && s.peek() == '(') || (str.charAt(i) == ']' && s.peek() == '[')
                        || (str.charAt(i) == '}' && s.peek() == '{')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (validParenthesis_(str)) {
            System.out.println("String is a valid parenthesis.");
        } else {
            System.out.println("String is not having a valid parenthesis.");
        }
    }
}