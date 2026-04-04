import java.util.Stack;

public class Queue_implementation_2Stack {
    static class Queue{
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }


        public void add(int data){
            if(isEmpty()){
                s1.push(data);
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());   //transferring data from s1 to s2
            }

            s1.push(data); // pushing the data in the empty s1.

            while(!s2.isEmpty()){
                s1.push(s2.pop()); //reverting back the data from s2 to s1.
            }
        }

        public void remove(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }
            s1.pop();
        }

        public void peek(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }
            System.out.println(s1.peek());
        }
    }
    public static void main(String args[]){
        Queue q1=new Queue();
        q1.add(1);
        q1.add(2);
        // q1.add(3);
        q1.add(4);
        while(!q1.isEmpty()){
            q1.peek();
            q1.remove();
        }
    }
}
