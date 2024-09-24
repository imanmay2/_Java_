import java.util.Stack;
public class stack_practise{
    //Push at the bottom of the Stack.
    public static void push_Bottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        push_Bottom(s,data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s=new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);
        push_Bottom(s, 1);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}