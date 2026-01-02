// Write a program that will swap in the given indexes in the arraylist.


import java.util.*;
public class Swap_idx_ArrayList{
    public static void print(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int idx1=sc.nextInt();
        int idx2=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.print("Enter the range of the array list : ");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("Enter the number to be inserted : ");
            list.add(sc.nextInt());
        }
        //swapping main algorithm.
        print(list);
        int temp=list.get(idx2);
        list.set(idx2,list.get(idx1));
        list.set(idx1,temp);
        print(list);


        
    }
}