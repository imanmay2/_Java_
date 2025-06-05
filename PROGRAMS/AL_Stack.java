import java.util.ArrayList;

public class AL_Stack {

    public static class Stack{
        ArrayList<Integer> list=new ArrayList<>();
        
        public boolean isEmpty(){
            return list.size()==0;
        }
        public void push(int data){
            list.add(data);

        }

        public void pop(){
            //removing the last element from the stack.
            if(list.size()==0){
                System.out.println("Stack is empty");
                return;
            }
            list.remove(list.size()-1);
        }
        public void peek(){
            if(list.size()==0){
                System.out.println("Stack is empty!");
            }
            System.out.println("Peek element in the stack is: "+list.get(list.size()-1));
        }

        public void display(){
            System.out.println(list);
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
        s.display();
        s.peek();
    }
}
