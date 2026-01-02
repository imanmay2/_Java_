import java.util.*;
import java.util.LinkedList;
public class Queue_JCF{
    public static void main(String args[]){
        Queue<Integer> q1=new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}