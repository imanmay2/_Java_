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
    public void addFirst(int data){
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

    //print  a Double_LinkedList.
    public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<--->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.print_LL();
        // ll.removeFirst();
        // ll.print_LL();
    }
}