// Implement Queues in the LinkedList.


import java.util.*;
public class Queue_LL{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class Queue{
        static Node head=null;
        static Node tail=null;

        //Checking for isEmpty()------
        public static boolean isEmpty(){
            if(head==null && tail==null){
                return true;
            }
            return false;
        }

        //Adding element into the Queue.
        public static void add(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        //Removing the peek element from the FIFO order.
        public static int remove(){
            int r;
            if(isEmpty()){
                System.out.println("The Queue is empty.");
                return -1;
            }
            if(head==tail){
                r=head.data;
                head=tail=null;
                return r;
            }
            r=head.data;
            head=head.next;
            return r;
        }


        //displaying the peek element from the Queue.
        public static int peek(){
            if(isEmpty()){
                System.out.println("The Queue is Empty .");
                return -1;
            }
            int r=head.data;
            return r;
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