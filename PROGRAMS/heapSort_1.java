import java.util.*;

public class heapSort_1{


    public static class Heap{
        private static void heapify(int i,int n,ArrayList<Integer> list){
            int leftIdx=(2*i)+1;
            int rightIdx=(2*i)+2;
            int maxIdx=i;

            if(leftIdx<=n && list.get(maxIdx)<list.get(leftIdx)){
                maxIdx=leftIdx;
            }

            if(rightIdx<=n && list.get(maxIdx)<list.get(rightIdx)){
                maxIdx=rightIdx;
            }

            if(maxIdx==i){
                return;
            }

            //swapping
            int t=list.get(i);
            list.set(i,list.get(maxIdx));
            list.set(maxIdx,t);

            heapify(maxIdx,n,list);
        }
        public static void ascendingOrder(ArrayList<Integer> list){
            //changing into maxHeap. 
            
            int n=list.size()-1;
            for(int i=n/2;i>=0;i--){
                heapify(i,n,list);
            }

            
            

            // step:3 ,fixing the heap using heapify.
            while(n>0){
                int t=list.get(n);
                list.set(n,list.get(0));
                list.set(0,t);

                n--;
                heapify(0,n,list);
            }
        }

        public static void printList(ArrayList<Integer> list){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i)+" ");
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,4,5,3));
        Heap h1=new Heap();

        h1.ascendingOrder(list);
        h1.printList(list);
    }
}