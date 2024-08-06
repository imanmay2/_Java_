public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;        //creating head node.
    public static Node tail;        //creating tail Node.
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        newNode=head;
        size++;
    }



    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }


    public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
        System.out.print("Null");
    }



    public void addElement(int idx,int data){
        if(idx==0){
            addFirst(data);
            size++;
            return;
        }
        Node newNode=new Node(data);
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("The LinkedList is empty.");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            size--;
            int val=head.data;
            head=tail=null;
            head.next=null;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
        
    }

    public  void search_element(int ele){
        Node temp=head;
        int i=0;
        int f=0;
        while(temp!=null){
            if(ele==temp.data){
                System.out.println("Element found at index : "+ i);
                f=1;
                break;
            }
            i++;
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Element not found in the Linked List.");
        }
    }


    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
     }
     public void delete_Node_from_end(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }

        if(n==sz){
            head=head.next;
            return;
        }
        Node prev=head;
        int i=1;
        int toFind=sz-n;
        while(i<toFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;       //Doubtful in this Statement....
        return;
     }



    //Steps for checking pallindrome: 1. Find the middle Node. 2. Reverse the 2nd half linkedlist. 3.Comapre the 1st and the 2nd half linkedlist.

    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){       //doubt in this &&
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean check_pallindrome(){
    if(head==null || head.next==null){
        return true;
    }
        Node midNode=findMid(head);
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
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }


    public static boolean check_cycle_LL(){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public void remove_cycle_LL(){
        Node fast=head;
        Node slow=head;
        boolean f=false;
        while(fast!=null && fast.next!=null){           //doubt in this step..
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                f=true;
                break;
            }
        }
        if(f==true){
            Node prev=null;
            slow=head;
            while(fast!=slow){
                prev=fast;
                fast=fast.next;
                slow=slow.next;
            }
            prev.next=null;
            System.out.println("Cycle/Loop removed from the LinkedList.");
        }
        else{
            System.out.println("The Linked List is not in Loop/Cycle.");
        }
    }



    private Node getNode(Node head){
        Node slow=head;
        Node fast=head.next;    //doubt.
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    private Node merge(Node head1,Node head2){
        Node merged_LL=new Node(-1);
        Node temp=merged_LL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        }
        return merged_LL.next;
    }

    // Merge Sort on a LinkedList.
    public Node merge_sort(Node head){
        if(head==null || head.next==null){
            return head; //basecase.
        }
        Node mid_node=getNode(head);
        Node right=mid_node.next;
        mid_node.next=null;
        Node left_node=merge_sort(head);
        Node right_node=merge_sort(right);
        return merge(left_node,right_node);
    }



    //zig zag LinkedList.
    public void zig_zag_LL(){

        //Step:1 ..to find the middle node..
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid_Node=slow;  
        
        //Step:2 , reverse the 2nd half of the LinkedList.
        Node prev=null;
        Node curr=mid_Node;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

       

        // Step : 3...    zig-zag...
        Node right_=prev;
        Node left_=head;
        Node nextL,nextR;
        while(right_!=null && left_!=null){
            nextL=left_.next;
            left_.next=right_;
            nextR=right_.next;
            right_.next=nextL;
            left_=nextL;
            right_=nextR;
        }  
    }






    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);     //this is not calling...
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.print_LL();
        // // System.out.println();
        // // ll.addElement(1,6);
        // // ll.print_LL();
        // // System.out.println("The size of the LinkedList is : "+size);

        // // ll.removeFirst();
        // // ll.print_LL();
        // // System.out.println("The size of the LinkedList is : "+size);

        // // ll.search_element(3);
        // // ll.reverse();
        // // ll.print_LL();

        // // ll.delete_Node_from_end(3);
        // System.out.print(ll.check_pallindrome());

       ll.addLast(5);
       ll.addLast(4);
       ll.addLast(3);
       ll.addLast(2);
       ll.addLast(1);
       ll.print_LL();
    //    ll.merge_sort(ll.head);
    //    ll.print_LL();


        ll.zig_zag_LL();
        ll.print_LL();
    }
}