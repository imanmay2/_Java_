//Implementing Stack using 

import java.util.*;
public class Queue_LL {
    static class Node{
        static int data;
        static Node next;
        static int size=-1;
        public Node(int data){     //constructor.
            this.data=data;
            this.next=null;
        }

        //just initialization.
        public static Node head;
        public static Node tail;

        //Adding element in the Queue.
        public static void add(int data){
            Node newNode=new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        //Removing element from the Queue.
        public static int remove(){
            int val;
            if(size==-1){
                System.out.println("Queue is Empty !!");
                return -1;
            }


            //if there is only 1 element in the Queue.
            if(size==0){
                val=head.data;
                head=tail=null;
                size--;
                return val;
            }
            val=head.data;
            head=head.next;
            size--;
            return val;
        }


        public static int peek(){
            if(size==-1){
                System.out.println("Queue is Empty. ");
                return -1;
            }

            return head.data;
        }

    }

    
    public static void main(String args[]){

    }
}
