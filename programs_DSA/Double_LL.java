public class Double_LL{
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
    public static int size;

    //add 
    public void addFirst(int data){             //Not working...
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=null;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }


    //remove element from First.
    public void removeFirst(){
        if(head==null){
            System.out.println("Your LinkedList is Empty.");
            return;
        }
        else if(size==1){
            head=tail=null;
            size=0;
        }
        head=head.next;
        head.prev=null;
        size--;
    }


    public void removeLast(){       //Bug yet to be fixed...
        if(head==null){
            System.out.println("The LinkedList is Empty!!");
            return;
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }



    //print  a Double_LinkedList.
    public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<--->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }


    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.print_LL();
        System.out.println();
        ll.reverse();
        ll.print_LL();

        // ll.removeFirst();
        // ll.print_LL();
        // System.out.println();
        // ll.removeLast();
        // ll.print_LL();
        // ll.removeFirst();
        // ll.print_LL();
        // ll.removeFirst();
        // ll.print_LL();
        // ll.removeLast();
        // ll.print_LL();
    }
}