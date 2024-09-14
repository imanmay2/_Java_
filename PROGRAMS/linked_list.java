public class linked_list{
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

    public static void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public static void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public static boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public static void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
        System.out.print("Null");
    }

    public static void add_middle(int idx,int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            head=tail=newNode;
            return;
        }
        else if(idx==0){
            addFirst(data);
        }
        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public static void Remove_First(){
        if(head==null){
            System.out.println("LinkedList is Empty.");
            return;
        }
        head=head.next;
    }

    public static void Remove_Last(){
        if(head==null){
            System.out.println("Linked List is Empty.");
            return;
        }
    }
    public static void main(String args[]){
        linked_list ll=new linked_list();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add_middle(2,0);
        ll.print_LL();
    }
}