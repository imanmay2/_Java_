import java.util.*;

public class Connect_N_Ropes {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the element : ");
            int ele=sc.nextInt();
            pq.add(ele);
        }

        int cost=0;
        while(pq.size()>1){
            int sum=(pq.remove()+pq.remove());
            cost=cost+sum;
            pq.add(sum);
        }

        System.out.println("Minimum cost of the Rope : "+cost);

    }
}
