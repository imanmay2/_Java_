import java.util.*;
public class Queue_using_2Stack {
    public static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        //isEmpty()---
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //Add Function.
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        
        //Remove() function.
        public static int remove(){
            if(isEmpty()){
                System.out.println("No element present !");
                return -1;
            }
            return s1.pop();
        }

        //peek() --fucntion...
        public static int peek(){
            if(isEmpty()){
                System.out.println("No element present !");
                return -1;
            }
            return s1.peek();
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
