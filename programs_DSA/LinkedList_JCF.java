import java.util.*;
public class LinkedList_JCF{
    public static void main(String args[]){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(1);
        System.out.print(ll);
    }
}