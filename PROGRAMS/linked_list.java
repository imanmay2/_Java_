public class linked_list {
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

     public void addFirst(int data){
        Node newNode=new Node(data);
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
            head=tail=newNode;   //it will create a singleNode.
            return;
        }
        tail.next=newNode;
        tail=newNode;
     }

     public void print_LL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
     }

     public void addMiddle(int idx,int data){
      Node newNode=new Node(data);
      Node temp=head;
      int i=0;
      while(i<idx-1){
         temp=temp.next;
         i++;
      }
      //logic for adding the node in the index.
      newNode.next=temp.next;
      temp.next=newNode;
     }



     public void size(){
      Node temp=head;
      while(temp!=null){
         size++;
         temp=temp.next;
      }
      System.out.println("Size of the LinkedList is: "+size);
     }

     public void removeFirst(){
      size();
      if(size==0){
         System.out.println("LinkedList is empty already!");
         return;
      }
      if(size==1){
         head=tail=null;
         return;
      }
      head=head.next;
     }

     public void reverse(){
      Node next;
      Node curr=tail=head;
      Node prev=null;
      while(curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
      }
      head=prev;
     }

     public void removeNthNodeEnd(int n){
      Node temp=head;
      int sz=0;
      while(temp!=null){
         temp=temp.next;
         sz++;
      }
      
      if(n==sz){
         head=head.next;
         return;
      }

      int i=0;
      Node t=head;
      int idx=sz-n;
      while(i<idx-1){
         t=t.next;
         i++;
      }
      t.next=t.next.next;
      return;
     }

     public void recursiveSearch(int key,Node temp,int idx){
      if(temp==null){
         System.out.println("Key not found in the list.");
         return;
      }
      if(key==temp.data){
         System.out.println("Found at index:"+idx);
         return;
      }
      recursiveSearch(key, temp.next, idx+1);
     }



     //middleNode
     public Node middleNode(Node head){
      //slow fast technique.
      Node slow=head;
      Node fast=head;
      while(fast!=null && fast.next!=null){
         slow=slow.next;
         fast=fast.next.next;
      }
      return slow; 
     }

     public void checkPallindrome(){
      if(head==null || head.next==null){
         System.out.println("Pallindrome!");
         return;
      }

      //find the middleNode.
      Node midNode=middleNode(head);


      //reverse the 2nd half of the LinkedList.
      Node curr=midNode;
      Node prev=null;
      Node next;
      while(curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
      }
      Node left=head;
      Node right=prev;

      //checking the pallindrome from the left side LL with the right side LL.
      while(right!=null){
         if(left.data!=right.data){
            System.out.println("Not Pallindrome");
            return;
         }
         left=left.next;
         right=right.next;
      }
      System.out.println("LinkedList is pallindrome.");
      return;
     }


      public static void main(String args[]){
        linked_list ll=new linked_list();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(0);
        ll.addLast(2);
        ll.addLast(0);
        ll.print_LL();
        ll.checkPallindrome();
        
      //   ll.reverse();
      //   ll.print_LL();

      //   ll.addMiddle(2,3);
      //   ll.print_LL();
      //   ll.removeFirst();
      //   ll.print_LL();
      //   ll.removeFirst();
      //   ll.print_LL();
      //   ll.recursiveSearch(4, head, 0);
     }
}
