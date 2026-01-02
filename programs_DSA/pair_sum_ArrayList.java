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
    public static void pair_sum_rotated_sorted(ArrayList<Integer> list,int target){
        int bp=-1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int n=list.size();
        int rp=bp;
        int lp=bp+1;
        while(lp!=rp){
            if(target==list.get(lp)+list.get(rp)){
                System.out.print("Match Found!! " + list.get(lp)+" "+list.get(rp));
                break;
            }
            else if(list.get(lp)+list.get(rp)>target){
                rp=(rp+n-1)%n;
            }
            else{
                lp=(lp+1)%n;
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        pair_sum_rotated_sorted(list,16);

    }
}