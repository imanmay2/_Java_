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
    public static int size;

    public static void addFirst(int data){      
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }

    public static void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
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
        if(head==null){
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
        size++;
    }
    public static void Remove_First(){
        if(size==0){
            System.out.println("LinkedList is Empty.");
            return;
        }
        else if(size==1){
            head=tail=null;
            size--;
            return;
        }
        head=head.next;
        size--;
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