import java.util.*;


public class Weekest_Soldier {
    static class Soldier implements Comparable<Soldier>{
        int idx,ct;
        public Soldier(int idx,int ct){
            this.idx=idx;
            this.ct=ct;
        }

        @Override
        public int compareTo(Soldier s1){
            if(s1.ct==this.ct){
                return this.idx-s1.idx;
            }
            return this.ct-s1.ct;
        }
    }


    public static int countSoldier(int arr[]){
        int ct=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                ct++;
            }
        }
        return ct;
    }
    public static void main(String args[]){
        int k=2;
        int arr[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0},
        };

        PriorityQueue<Soldier> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int ct=countSoldier(arr[i]);
            pq.add(new Soldier(i, ct));
        }

        for(int i=0;i<k;i++){
            System.out.println("Row"+pq.remove().idx+" ");
        }
    }
}
