import java.util.*;
import java.util.Comparator;

public class priorityQueue{

    static class Student implements Comparable<Student>{
        String name;
        int roll;
        public Student(String name,int roll){
            this.name=name;
            this.roll=roll;
        }

        public int compareTo(Student s2){
            return this.roll-s2.roll;
        }
    }

    public static void PQ(){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(1);
        pq.add(5);
        pq.add(6);
        pq.add(2);
        pq.add(4);

        System.out.println("Elements in the Priority Queue are : ");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }


    public static void addObjPQ(){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Anwesha",03));
        pq.add(new Student("Manmay",06));
        pq.add(new Student("Hello",01));
        pq.add(new Student("Welcome",07));
       

        System.out.println("Elements in the Priority Queue are : ");
        while(!pq.isEmpty()){
            Student s=pq.peek();
            System.out.println(s.name+" "+s.roll);
            pq.remove();
        }
    }
    public static void main(String args[]){
        addObjPQ();

    }
}