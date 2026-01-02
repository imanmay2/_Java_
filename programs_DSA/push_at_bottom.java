import java.util.*;
public class push_at_bottom{
    public static void push_bottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top;
        top=s.pop();
        push_bottom(s, data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s=new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        push_bottom(s, 0);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}