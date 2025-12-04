import java.util.PriorityQueue;
import java.util.Comparator;
public class priorityQueue{

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
    public static void main(String args[]){
        PriorityQueue<Student> pq=new PriorityQueue<>();

        pq.add(new Student("Anwesha",1));
        pq.add(new Student("Manmay",5));
        pq.add(new Student("Lopa",3));
        pq.add(new Student("Vishesh",2));



        System.out.println("Elements in the priority Queue are : ");

        while(!pq.isEmpty()){
            Student s=pq.remove();
            System.out.println(s.name+"--->"+s.rank);
        }
    }
}