import java.util.Stack;

public class pushBottomStack{

    public static void pushBottom(Stack<Integer> s,int n){
        if(s.isEmpty()){
            s.push(n);
            return;
        }
        int top=s.pop();
        pushBottom(s, n);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushBottom(s, 0);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}