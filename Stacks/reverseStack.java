import java.util.Stack;

public class reverseStack {

    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top=s.pop();
        pushBottom(s, data);
        s.push(top);
    }


    public static void reverse_Stack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverse_Stack(s);
        pushBottom(s, top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverse_Stack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}