import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;

public class PriorityQueue_{

    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void PQ_Student(){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Anwesha",5));
        pq.add(new Student("Manmay",4));
        pq.add(new Student("Lopa",1));
        pq.add(new Student("Ash Ketchm",2));

        while(!pq.isEmpty()){
            Student s=pq.remove();
            System.out.println("Student name : "+s.name+ "Rank of the student : "+s.rank);
        }
    }

    public static void PQ(){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(20);
        pq.add(14);
        pq.add(18);
        pq.add(19);

        while(!pq.isEmpty()){
            System.out.println(pq.remove()+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        PQ_Student();

        
    }
}