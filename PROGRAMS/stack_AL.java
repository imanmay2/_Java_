// Implementing Stack using ArrayList.

import java.util.*;
public class stack_AL{
    static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();


        public static void push(int n){
            list.add(n);
            System.out.println("Item pushed!!");
        }


        public static void peek(){
            if(list.size()==0){
                System.out.println("List is empty.");
                return;
            }
            System.out.println("The Peek element of the Stack is "+list.get(list.size()-1));
        }


        public static int pop(){
            if(list.size()==0){
                System.out.println("Stack is empty");
                return 0;
            }
            int p=list.size()-1;
            System.out.println("The poped element is "+list.remove(list.size()-1));
            return p;
        }

        
    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(list.size()!=0){
            s.pop();
        }
    }
}