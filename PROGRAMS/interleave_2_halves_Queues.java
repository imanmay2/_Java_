import java.util.*;
public class interleave_2_halves_Queues {
    public static void interleave(Queue<Integer> q1){
        Queue<Integer> q2=new ArrayDeque<>();
        int size=q1.size()/2;
        for(int i=1;i<=size;i++){
            q2.add(q1.remove());
        }

        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }
    public static void main(String args[]){
        Queue<Integer> q1=new ArrayDeque<>();
        for(int i=1;i<=10;i++){
            q1.add(i);
        }
        interleave(q1);
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }

    }
    
}
