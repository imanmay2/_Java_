// Pair Sum code: 1

import java.util.*;
public class pair_sum_ArrayList{
    public static void sum_pair_1(ArrayList<Integer> list,int target){
        int lp=0;
        int rp=list.size()-1;


        //Time complexity: O(n)
        while(lp<rp){
            if(target==(list.get(lp)+list.get(rp))){
                System.out.print("Pair found!!"+ list.get(lp)+" "+list.get(rp));
                break;
            }
            else if((list.get(lp)+list.get(rp))>target){
                rp--;
            }
            else{
                lp++;
            }
            
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        sum_pair_1(list,5);

    }
}