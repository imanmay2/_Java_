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
    public static void Reverse_LL(){
        Node next;
        Node prev=null;
        Node curr=tail=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    


    public static void Remove_Nth_Node_from_end(int ele_){
        if(ele_>size){
            System.out.println("Sorry, Index out of Bound!!!");
            return;
        }
        int idx=size-ele_;
        int i=0;
        Node temp=head;
        while(i<idx-1){
            i++;
            temp=temp.next;
        }

        temp.next=temp.next.next;
        size--;
    }

    public static  Node find_midNode(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static boolean check_Pallindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode=find_midNode();

        //Reverse the 2nd half of the LinkedList.
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;


        //checking the 1st and 2nd half.
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    
    public static void main(String args[]){
        linked_list ll=new linked_list();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print_LL();
        System.out.println(ll.check_Pallindrome());
        System.out.println();
        System.out.println();
        System.out.println("The length of the linked list is : "+ll.size);
    }
}