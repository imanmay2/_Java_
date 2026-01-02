public class circular_Queue {
    static class Queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n){
            arr=new int[n];
            size=n;
            front=rear=-1;
        }

        //Checking for the Empty Queue.
        public static boolean isEmpty(){
            return (front==-1 && rear==-1);
        }

        //Checking for the Full Queue.
        public static boolean isFull(){
            return (rear+1)%size==front;
        }

        ////Adding elements into the Queue.
        public static void add(int data){
            //Time Complexity : O(1)
            if(isFull()){
                System.out.println("The Queue is already being fulled.");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;

            //this will execute for the first time only...
        }


        //removing the element from the Queue.
        public static int remove(){
            //Time Complexity : O(1)
            int r;
            if(isEmpty()){
                System.out.println("The Queue is Empty.");
                return -1;
            }
            //if there is only one element in the Queue.
            r=arr[front];
            if(rear==front){
                front=rear=-1;
                return r;
            }
            front=(front+1)%size;
            return r;
        }


        //displaying the peek element from the Queue.
        public static int peek(){
            //Time Complexity : O(1)
            if(isEmpty()){
                System.out.println("The Stack is Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String args[]){

        Queue q1=new Queue(4);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);

        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }

    }
}
