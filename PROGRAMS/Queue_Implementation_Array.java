public class Queue_Implementation_Array {
    static class Queue {
        static int arr[];
        static int rear = -1;
        static int size;

        Queue(int n) {
            size = n;
            arr = new int[n];
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void enque(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full.");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public void dequeue() {
            if (rear == -1) {
                System.err.println("Queue is empty");
            }
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
        }

        public void peek() {
            if (rear == -1) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.println(arr[0]);
        }
    }

    public static void main(String args[]){
        Queue q1 = new Queue(5);
        q1.enque(1);
        q1.enque(2);
        q1.enque(3);
        q1.enque(4);
        q1.enque(5);
        while (!q1.isEmpty()){
            q1.peek();
            q1.dequeue();
        }
    }
}