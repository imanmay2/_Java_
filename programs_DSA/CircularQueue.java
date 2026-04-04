public class CircularQueue {
    static class Queue{
        public static int size;
        static int arr[];
        public static int front=-1;
        public static int rear=-1;
        public Queue(int n){
            arr=new int[n];
            size=n;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public boolean isFull(){
            return (rear+1)%size==front;
        }
        public void enque(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(front==-1){
                front++;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        public void dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }

            int r=arr[front];
            if(front==rear){
                front=rear=-1;
                System.out.println("Dequeued "+r);
                return;
            }
            front=(front+1)%size;

            System.out.println("Dequeued "+r);
        }

        public void peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty.");
                return;
            }
            System.out.println(arr[front]);
        }
    }
    public static void main(String args[]){
        Queue q1=new Queue(5);
        q1.enque(1);

        q1.enque(2);
        q1.enque(3);
        q1.enque(4);
        q1.enque(5);
        q1.enque(0);
        // while(!q1.isEmpty()){
        //     // q1.peek();
        //     q1.dequeue();
        // }
    }
}
