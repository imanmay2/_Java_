import java.util.*;

public class Majority_Element{
    public static void main(String args[]){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int arr[]={1,2};
        System.out.println("Majority Element...");

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                for(Integer key:hm.keySet()){
                    if(key==arr[i]){
                        int val=hm.get(key);
                        hm.put(key,++val);
                    }
                }
            } else{
                //key is not present 
                hm.put(arr[i],1);
            }
        }

        int k=arr.length/3;

        for(Integer key:hm.keySet()){
            if(hm.get(key)>=k){
                System.out.print(key+" ");
            }
        }

    }
}