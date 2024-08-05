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

    private Node getMid(Node head){
        Node fast=head.next;            //doubt in this step....
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }


    private Node merge(Node head1,Node head2){
        Node merge_LL=new Node(-1);
        Node temp=merge_LL;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                temp.next=head1;
                temp=temp.next;
                head1=head1.next;
            }
            else{
                temp.next=head2;
                temp=temp.next;
                head2=head2.next;
            }
        }
        while{head!=null}{
            temp.next=
        }

        }
    }

    // Merge Sort on a LinkedList.
    public void merge_sort(Node head){          
        //basecase.
        if(head==null || head.next==null){
            return head;
        }
        Node mid_Node=getMid(head);
        Node rightNode=mid_Node.next;
        Node newLeft=merge_sort(head);
        Node newRight=merge_sort(rightNode);
        return merge(newLeft,newRight);
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

        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=temp;
        ll.remove_cycle_LL();
        ll.print_LL();
    }
}