public class Loop_LL {
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

    public void checkFlyods_LL(){
        if(head==null || head.next==null){
            System.out.println("Not a Flyod's LinkedList ! ");
            return;
        }


        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("Loop Detected ! ");
                return;
            }
        }

        System.out.println("Loop not Detected!!");
        return;
    }


    public void removeCycle(){
        boolean isCycle=false;
        Node slow=null;
        Node fast=null;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                isCycle=true;
            }
        }
        if(!isCycle){
            return;
        }

        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        prev.next=null;
        return;
    }


    public static void main(String args[]){

        //Loop_Ll
        Loop_LL ll=new Loop_LL();
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        // Creating the list: 10 -> 20 -> 30 -> 40 -> 50
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop here: 50 -> 30
        fifth.next = third;

        
        // ll.checkFlyods_LL();
        ll.removeCycle();
        ll.checkFlyods_LL();
    }
}
