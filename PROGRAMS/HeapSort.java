import java.util.*;
public class HeapSort{

    public static void heapify(ArrayList<Integer> list,int i,int n){
        int left=(2*i)+1;
        int right=(2*i)+2;
        int max=i;

        if(left<=n && list.get(left)>list.get(max)){
            max=left; 
        } if(right<=n && list.get(right)>list.get(max)){
            max=right;
        }


        if(i==max){
            return;
        }

        //swapping 
        int temp=list.get(i);
        list.set(i,list.get(max));
        list.set(max,temp);

       heapify(list,max,n);
    }

    public static void heapSort(ArrayList<Integer> list){

        //step 1 to convert the array into a maxHeap so as to get the ascending order.
        int n=list.size()-1;
        for(int i=(n/2);i>=0;i--){
            heapify(list,i,n);
        }


        //step:2 got maxHeap now Sorting the arrayList.
        
        while(n>0){
            int temp=list.get(0);
            list.set(0,list.get(n));
            list.set(n,temp);

            n--;
            heapify(list,0,n);
            
        }
    }

    public static void printList(ArrayList<Integer> list){
        System.out.println("Updated Heap is : ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }System.out.println();
    }

    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,4,5,3));

        printList(list);

        heapSort(list);

        printList(list);
    }
}