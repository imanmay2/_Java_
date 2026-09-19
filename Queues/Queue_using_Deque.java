import java.util.*;
public class Queue_using_Deque {
    static class Queue{
        static Deque<Integer> q1=new ArrayDeque<>();
        
        //isEmpty---
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        //add()--
        public static void add(int data){
            q1.addFirst(data);
        }

        //remove()---
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty.");
                return -1;
            }
            return q1.removeFirst();
        }

        //peek()---
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty!!");
                return -1;
            }
            return q1.getFirst();
        }
    }
    public static void main(String args[]){
        Queue q1=new Queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }

    }
}
