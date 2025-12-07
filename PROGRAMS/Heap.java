import java.util.*;

public class Heap{

    //inserting into the heap(min heap).
    public static void insertHeap(ArrayList<Integer> list,int ele){
        list.add(ele);
        int i=list.size()-1;
        while(i>0){
            int pIdx=(i-1)/2;
            if(list.get(pIdx)>list.get(i)){
                //swapping the values.
                int t=list.get(i);
                list.set(i,list.get(pIdx));
                list.set(pIdx,t);
            }
            i=pIdx;
        }
    }

    //peek element from the heap(min heap).
    public static int peekHeap(ArrayList<Integer> list){
        return list.get(0);
    }

    
    //printing the arrayList
    public static void printList(ArrayList<Integer> list){
        System.out.println("Elements in the list are : ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        } System.out.println();
    }


    public static void heapify(int i,ArrayList<Integer> list){
        int leftIdx=2*i+1;
        int rightIdx=2*i+2;
        int minIdx=i;

        if(leftIdx<list.size() && list.get(minIdx)>list.get(leftIdx)){
            minIdx=leftIdx;
        }

        if(rightIdx<list.size() && list.get(minIdx)>list.get(rightIdx)){
            minIdx=rightIdx;
        }

        if(i==minIdx){
            return;
        }

        //swapping
        int temp=list.get(i);
        list.set(i,list.get(minIdx));
        list.set(minIdx,temp);

        heapify(minIdx,list);
        

    }
    //remove element from the heap.
    public static int removeHeap(ArrayList<Integer> list){

        //step1 : swapping the first and the last node
        int t=list.get(0);
        list.set(0,list.get(list.size()-1));
        list.set(list.size()-1,t);

        //step 2 : remove the last node
        int data=list.get(list.size()-1);
        list.remove(list.size()-1);

        //step:3 heapify / fix the heap
        heapify(0,list);

        return data;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5,10,6));
        // insertHeap(list,1);
        // printList(list);

        // System.out.println("Peek element from the heap is : ");
        // System.out.println(peekHeap(list));

        // System.out.println("Element removed from the Heap is : "+removeHeap(list));
        
        // printList(list);
        System.out.println("Element removed from the Heap is : "+removeHeap(list));
        
        printList(list);
    }
}