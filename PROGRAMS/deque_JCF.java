import java.util.*;
public class deque_JCF {
    public static void main(String args[]){
        Deque<Integer> q1=new ArrayDeque<>();
        q1.addFirst(1);
        q1.addFirst(2);
        q1.addLast(3);
        q1.addLast(4);
        System.out.println(q1);
        q1.removeFirst();
        System.out.println(q1);
        System.out.println(q1.getFirst());
        System.out.println(q1.getLast());
    }
}
