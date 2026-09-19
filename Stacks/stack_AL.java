// Implementing Stack via ArrayList.

import java.util.*;
public class stack_AL{
    static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty(){
            if(list.size()==0){
                return true;
            }
            return false;
        }

        public static void push(int n){
            list.add(n);
        }

        public static void peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty.");
                return;
            }
            System.out.println(list.get(list.size()-1));
            return;
        }


        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty.");
                return -1;
            }
            int val=list.get(list.size()-1);
            // System.out.println("The popped element is : "+val);
            list.remove(list.size()-1);
            return val;
        }

        public static void print_stack(){
            for(int i=list.size()-1;i>=0;i--){
                System.out.println(list.get(i));
            }
        }
    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            s.peek();
            s.pop();
        }
    }
}