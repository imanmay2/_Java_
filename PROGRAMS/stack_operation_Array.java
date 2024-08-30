
// Implementing Stack Operation with the help of Array.


public class stack_operation_Array {
    public static class Stack{
        static int arr[];
        static int size;
        static int ct;
        Stack(int n){
            arr=new int[n];
            size=n;
            ct=-1;
        }

        
        //checking whether the stack is empty or not.
        public static boolean isEmpty(){
            return ct==-1;
        }


        // Adding element in to the stack.
        public static void add(int data){
            if(ct==size-1){
                System.out.println("The Stack is full.");
                return;
            }
            ct++;
            arr[ct]=data;
        }


        //removing element from the Stack.
        public static int remove(){
            if(isEmpty()){
                System.out.println("The Stack is already being Empty.");
                return -1;
            }

            int re=arr[ct];
            for(int i=0;i<ct;i++){
                arr[i]=arr[i+1];
            }
            ct--;
            return re;
        }

        //Displaying the peek element from the Stack.
        public static int peek(){
            if(isEmpty()){
                System.out.println("The Stack is Empty.");
                return -1;
            }
            return arr[ct];
        }
    }
    public static void main(String args[]){
        Stack s=new Stack(4);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.remove();
        }
    }
}
