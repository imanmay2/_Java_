import java.util.*;

public class Heap{
    public static ArrayList<Integer> insertHeap(ArrayList<Integer> list,int ele){
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
        return list;
    }

    public static void printList(ArrayList<Integer> list){
        System.out.println("Elements in the list are : ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5,10));
        ArrayList<Integer> list1=insertHeap(list,1);
        printList(list1);
    }
}