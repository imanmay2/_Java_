import java.util.*;
public class Stack_using_Deque {
    static class Stack{
        static Deque<Integer> q1=new ArrayDeque<>();

        //isEmpty()--- 
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        // push()---
        public static void push(int data){
            q1.addLast(data);
        }

        //pop()---
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.removeLast();
        }


        //peek()----
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty !");
                return -1;
            }
            return q1.getLast();
        }
    }
    public static void main(String args[]){
        Stack s1=new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }

    }
}
