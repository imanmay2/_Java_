public class LinkedList_Queue_Implementation {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    static class Queue {
        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            head = head.next;
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.println(head.data);
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Queue q1 = new Queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.display();
        q1.peek();
    }
}
