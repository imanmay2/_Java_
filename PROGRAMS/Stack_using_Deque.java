import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_using_Deque{
    static class Stack{
        Deque<Integer> d1=new ArrayDeque<>();

        public boolean isEmpty(){
            return d1.isEmpty();
        }

        public void push(int data){
            //function.
            d1.addFirst(data);
        }

        public void pop(){
            //function.
            if(d1.isEmpty()){
                System.out.println("Stack is empty.");
                return;
            }
            d1.removeFirst();
        }

        public void peek(){
            //function.
            if(d1.isEmpty()){
                System.out.println("Stack is empty.");
                return;
            }
            System.out.println(d1.getFirst());
        }

    }
    public static void main(String args[]){
        Stack st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        while(!st.isEmpty()){
            st.peek();
            st.pop();
        }
    }
}
