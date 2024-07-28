import java.util.*;
public class LinkedList_basics{
    public static void main(String args[]){
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);
    }
}


//Creating Nodes....:--->>> 


public static class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public static Node head;
public static Node tail;
public static int size;


// Add_First in the linked list.(Head wil change every time).
public void addFirst(int data){
    Node newNode=new Node(data);
    if(head==null){
        head=tail=newNode;
        return;
    }
    newNode.next=head;
    head=newNode;
}


