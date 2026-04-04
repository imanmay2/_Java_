import java.util.*;

public class Heap_1{

    public static void printAL(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        } System.out.println();
    }

    static class Heap{
        public static ArrayList<Integer> insertHeap(ArrayList<Integer> list,int ele){
            list.add(ele);
            int i=list.size()-1;
            while(i>0){
                int pIdx=(i-1)/2;

                if(list.get(pIdx)>list.get(i)){
                    //swap
                    int t=list.get(i);
                    list.set(i,list.get(pIdx));
                    list.set(pIdx,t);
                }
                i=pIdx;
            }

            return list;
        }

        public static void heapify(int i,ArrayList<Integer> list){
            int minIdx=i;
            int leftIdx=(2*i)+1;
            int rightIdx=(2*i)+2;

            if(list.size()>leftIdx && list.get(minIdx)>list.get(leftIdx)){
                minIdx=leftIdx;
            }

            if(list.size()>rightIdx && list.get(minIdx)>list.get(rightIdx)){
                minIdx=rightIdx;
            }

            if(i==minIdx){
                return; //as nothing changed...
            }

            //else swap.
            int t=list.get(i);
            list.set(i,list.get(minIdx));
            list.set(minIdx,t);

            heapify(minIdx,list);
        }


        public static int removeHeap(ArrayList<Integer> list){
            //swapping
            int t=list.get(0);
            list.set(0,list.get(list.size()-1));
            list.set(list.size()-1,t);

            int data=list.remove(list.size()-1);

            heapify(0,list);

            return data;
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5,10,6));

        printAL(list);
        Heap h1=new Heap();
        // ArrayList<Integer> newList=h1.insertHeap(list,1);
        // printAL(newList);

        int ele=h1.removeHeap(list);
        printAL(list);
        System.out.println("Element removed from the heap is : "+ele);
    }
}