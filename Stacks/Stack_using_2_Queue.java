import java.util.ArrayDeque;
import java.util.Queue;

public class Stack_using_2_Queue {

    static class Stack {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public int findPeek(Queue<Integer> q) {
            return q.peek();
        }

        public int pop_(Queue<Integer> q1, Queue<Integer> q2) {
            int top=0;
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (q1.isEmpty()) {
                    break;
                }
                q2.add(top);
            }
            return top;
        }

        public void push(int data) {
            if (isEmpty()) {
                q1.add(data);
            } else {
                if (q1.isEmpty()) {
                    q2.add(data);
                } else {
                    q1.add(data);
                }
            }
        }


        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            } else {
                if (!q1.isEmpty()) {
                    return pop_(q1,q2);
                } else {
                    return pop_(q2,q1);
                }
            }
        }

        public void findPeek(Queue<Integer> q1,Queue<Integer> q2){
            int top=0;
            while(!q1.isEmpty()){
                top=q1.remove();
                q2.add(top);
            }
            System.out.println("Peek element is: "+top);
        }

        public void peek(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
                return;
            }
            if(!q1.isEmpty()){
                findPeek(q1,q2);
            } else{
                findPeek(q2,q1);
            }
        }
    }

    public static void main(String args[]) {
        Stack s1=new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.peek();
        while(!s1.isEmpty()){
            s1.pop();
            if(s1.isEmpty()){
                break;
            }
            s1.peek();
        }
    }
}
