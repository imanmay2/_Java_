import java.util.ArrayList;
import java.util.Arrays;

public class pairSum_2 {

    public static boolean pairSum2(ArrayList<Integer> arr,int tar){
        int bp=0;
         for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                bp=i;
            }
         }

         int rp=bp;
         int lp=bp+1;


         while(lp!=rp){
            if(arr.get(lp)+arr.get(rp)==tar){
                return true;
            }

            else if(arr.get(rp)+arr.get(lp)>tar){
                rp=(arr.size()+rp-1)%arr.size();
            } else{
                lp=(lp+1)%arr.size();
            }
         }

         return false;
    } 
    public static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(11,15,6,8,9,10));
        System.out.println(pairSum2(arr,1));
    }
}
