// Write a program that will implement all the basic functions of ArrayLists.



import java.util.*;
public class ArrayLists{
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0,0);
        list.set(2,3);
        System.out.println(list);
        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list);
        System.out.print(list.get(1));
    }
}