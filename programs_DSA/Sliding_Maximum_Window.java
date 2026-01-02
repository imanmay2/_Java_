import java.util.*;

public class Sliding_Maximum_Window {

    static class Window implements Comparable<Window>{
        int idx,val;
        public Window(int idx,int val){
            this.idx=idx;
            this.val=val;
        }

        @Override
        public int compareTo(Window w1){
            return w1.val-this.val;
        }
    }

    public static void printList(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }System.out.println();
    }
    
    public static void main(String args[]){
        PriorityQueue<Window> pq=new PriorityQueue<>();

        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();

        int ct=0;
        while(ct!=3){
            pq.add(new Window(ct,arr[ct]));
            ct++;
        }

        list.add(pq.peek().val);

        for(int i=ct;i<n;i++){
            while(pq.peek().idx<i-k+1){
                pq.remove();
            }

            pq.add(new Window(i, arr[i]));

            list.add(pq.peek().val);
        }

        printList(list);
    }
}
