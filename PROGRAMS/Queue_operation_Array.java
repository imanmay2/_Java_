import java.util.*;
public class Queue_operation_Array{
    static class Queue{
        //initialisation.
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){           //constructor.
            arr=new int[n];
            size=n;
            rear=-1;
        }

        //Checking --if it's empty or not...
        public static boolean isEmpty(){
            return rear==-1;
        }

        
        //Adding element in the Queue.
        public static void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full !!");
                return;
            }
            rear++;
            arr[rear]=data;
        }

        //Removing an element form the Queue.
        public static void remove(){
            if(isEmpty()){
                System.out.println("Sorry, the Queue is Empty ! ");
                return;
            }

            //removing element..

            //Time Complexity is : O(n).... which is not optimized so far.
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
        }

        public static void peek(){
            if(isEmpty()){
                System.out.println("The Queue is Empty!!");
                return;
            }
            System.out.println(arr[0]);
        }

    }
    public static void main(String args[]){
        Queue q=new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(5);
        while(!q.isEmpty()){
            q.peek();
            q.remove();
        }
    }
}
