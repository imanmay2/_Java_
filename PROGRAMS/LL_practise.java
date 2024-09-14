public class LL_practise{
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
            System.out.println(temp.data+"---->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String args[]){
        
    }
}