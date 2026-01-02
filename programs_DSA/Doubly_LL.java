public class Doubly_LL {

    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;   //doubly linkedlist.
        head=newNode;
    }
    public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void removeFirst(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=tail=null;
            return;
        }

        head=head.next;
        head.prev=null;
        return;
    }
    public void removeLast(){
        if(head==null){
            return;
        }

        tail=tail.prev;
        tail.next=null;
    }

    public void reverse_DLL(){
        Node curr=tail=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;  ///for doubly LinkedList.
            prev=curr;
            curr=next;
        }
        tail=head;
        head=prev;
    }


    public static void main(String args[]){
        Doubly_LL ll=new Doubly_LL();
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        // ll.print_LL();
        // ll.removeFirst();
        // ll.print_LL();
        // ll.removeLast();
        ll.reverse_DLL();
        ll.print_LL();
    }
}
