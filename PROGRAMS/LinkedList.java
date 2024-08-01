public class LinkedList{
    public static class Node{
        int data;
        int next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;        //creating head node.
    public static Node tail;        //creating tail Node.

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }
        newNode.next()=head;
        newNode=head;
    }



    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }

        tail.next()=newNode;
        tail=newNode;
    }


    public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next();
        }
        System.out.print("Null");
    }


    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print_LL();
    }
}