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
            return (rear==front && rear!=-1 && front!=-1);
        }

        ////Adding elements into the Queue.
        public static void add(int data){
            if(isFull()){
                System.out.println("The Queue is already being fulled.");
                return;
            }
            rear=(rear+1)%size;
            arr[rear]=data;

            //this will execute for the first time only...
            if(rear==0){
                front=0;
            }
        }


        //removing the element from the Queue.
        public static int remove(){
            int r;
            if(isEmpty()){
                System.out.println("The Queue is Empty.");
                return -1;
            }
            //if there is only one element in the Queue.
            if(rear==front && arr.length==1){
                r=arr[rear];
                front=rear=-1;
                return r;
            }
            r=arr[front];
            front=(front+1)%size;
            return r;
        }


        //displaying the peek element from the Queue.
        public static int peek(){
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
