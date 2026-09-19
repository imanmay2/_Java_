import java.util.*;
public class stack_LL{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class stack{
        static Node head=null;


        //checking for Empty Stack.
        public static boolean isEmpty(){
            return head==null;
        }

        //Pushing into the stack.
        public static void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }


        //popping from the Stack.
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty now :(");
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }


        //Peek Element from the Stack.
        public static int peek(){
            if(isEmpty()){
                System.out.println("The Stack is Empty!");
                return -1;
            }
            System.out.println(head.data);
            return head.data;
        }
    }

    public static void main(String args[]){
       stack s=new stack();
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