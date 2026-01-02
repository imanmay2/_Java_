import java.util.ArrayDeque;
import java.util.Deque;
public class Queue__using_Deque {
    static class Queue{
        Deque<Integer> d1=new ArrayDeque<>();
        public boolean isEmpty(){
            return d1.isEmpty();
        }

        public void add(int data){
            d1.addLast(data);
        }

        public void remove(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }
            d1.removeFirst();
        }
        
        public void peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty.");
                return;
            }
            System.out.println(d1.getFirst());
        }
    }
    public static void main(String args[]){
        Queue q1=new Queue();
        for(int i=1;i<=3;i++){
            q1.add(i);
        }

        while(!q1.isEmpty()){
            q1.peek();
            q1.remove();
        }
    }
}