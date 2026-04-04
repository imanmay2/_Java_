public class LL_Stack{

     public static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next=null;
            }
        }

    public static class Stack{
        public static Node head;
        public static Node tail;
        public boolean isEmpty(){
            return head==null;
        }

        public void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
            return;
        }

        public void reverse(){
            Node curr=tail=head;
            Node next;
            Node prev=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }

        public void display(){
            reverse();
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
            reverse();
        }


        public void peek(){
            if(isEmpty()){
                System.out.println("No peek element found!");
                return;
            }
            if(head.next==null){
                System.out.println(head.data+" ");
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            System.out.println(temp.data+" ");
            return;
        }


        public void pop(){
            Node temp=head;
            if(isEmpty()){
                System.out.println("List is Empty");
                return;
            }
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.display();
        s.pop();
        s.peek();
        s.display();
    }
}