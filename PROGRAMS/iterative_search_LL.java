public class iterative_search_LL{
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
    

    public void addFirst(int data){
        Node newNode=new Node(data);        //creating newNode.
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }


    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }


    public  void search_element(int ele){
        Node temp=head;
        int i=0;
        int f=0;
        while(temp!=null){
            if(ele==temp.data){
                System.out.print("Element found at index : "+ i);
                f=1;
                break;
            }
            i++;
            temp=temp.next;
        }
        if(f==0){
            System.out.print("Element not found in the Linked List.");
        }
    }

    public void print_LL(){
        
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
    }



    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        print_LL();
        ll.search_element(3);
    }
}