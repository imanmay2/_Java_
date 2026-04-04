import java.util.ArrayDeque;
import java.util.Queue;
public class Reverse_Queue {
    public static Queue<Integer> reverseQueue(Queue<Integer> q1){
        int size=q1.size();
        int arr[]=new int[q1.size()];
        int j=0;
        while(!q1.isEmpty()){
            arr[j]=q1.peek();
            q1.remove();
            j++;
        }

        for(int i=size-1;i>=0;i--){
            q1.add(arr[i]);
        }

        return q1;
    }
        public static void main(String args[]){
        Queue<Integer> q1=new ArrayDeque<>();
        for(int i=1;i<=5;i++){
            q1.add(i);
        }

        q1=reverseQueue(q1);
        while(!q1.isEmpty()){
            System.out.print(q1.peek()+" ");
             q1.remove();
        }
    }
}
