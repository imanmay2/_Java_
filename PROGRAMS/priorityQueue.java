import java.util.PriorityQueue;
public class priorityQueue{
    public static void main(String args[]){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        pq.add(6);
        pq.add(4);
        pq.add(1);
        pq.add(7);


        System.out.println("Elements in the priority Queue are : ");

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}