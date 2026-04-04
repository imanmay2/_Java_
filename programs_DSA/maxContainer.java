import java.util.ArrayList;
import java.util.Arrays;

// 2 pointer approach..
public class maxContainer {
    public static int maxVol(ArrayList<Integer> arr){
        int lp=0;
        int rp=arr.size()-1;
        int vol=0;
        while(lp<rp){
            // calculate max
            vol=Math.max(vol,Math.min(arr.get(rp),arr.get(lp))*(rp-lp));

            if(arr.get(lp)<arr.get(rp)){
                lp++;
            } else{
                rp--;
            }
        }
        return vol;
    }
    public static  void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
        System.out.print(maxVol(arr));
    }
}
