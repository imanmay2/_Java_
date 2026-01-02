import java.util.ArrayList;
import java.util.Arrays;

public class pairSum1{

    public static void pairSum(ArrayList<Integer> arr,int target){
        int lp=0;
        int rp=arr.size()-1;
        boolean f=false;
        while(lp<rp){
            if(arr.get(rp)+arr.get(lp)==target){
                System.out.println("("+arr.get(lp)+","+arr.get(rp)+")");
                f=true;
                break;
            }

            else if(arr.get(lp)+arr.get(rp)>target){
                rp--;
            }else{
                lp++;
            }
            
            
        }
        if(!f){
            System.out.println("Pair not found!!");
        }

    }
    public static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        pairSum(arr,5);
    }
}