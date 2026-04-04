import java.util.*;
public class MultiDimensionalArrayList{
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> main_list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        for(int i=1;i<=5;i++){
            list1.add(1*i);
            list2.add(2*i);
            list3.add(3*i);
        }
        main_list.add(list1);
        main_list.add(list2);
        main_list.add(list3);
        for(int i=0;i<main_list.size();i++){
            ArrayList<Integer> curr=main_list.get(i);
            for(int j=0;j<curr.size();j++){
                System.out.print(curr.get(j)+" ");
            }
            System.out.println();
        }
    }
}