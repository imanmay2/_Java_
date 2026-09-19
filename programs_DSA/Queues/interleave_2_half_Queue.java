import java.util.ArrayDeque;
import java.util.Queue;

public class interleave_2_half_Queue {

    public static Queue<Integer> interleave(Queue<Integer> q1){
        Queue<Integer> q2=new ArrayDeque<>();
        int length=q1.size()/2;
        for(int i=1;i<=length;i++){
            q2.add(q1.remove());
        }
        for(int i=0;i<length;i++){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }

        return q1;
    }
    public static void main(String args[]){
        Queue<Integer> q1=new ArrayDeque<>();
        for(int i=1;i<=10;i++){
            q1.add(i);
        }

        Queue<Integer> q=interleave(q1);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");            
        }
    }
}
