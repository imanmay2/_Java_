import java.util.*;

public class count_distinct_ele{
    public static void main(String args[]){
        int arr[]={1,2,2,2,3,1,3,4};
        HashSet<Integer> hs=new HashSet<>();
        for(int i:arr){
            hs.add(i);
        }

        System.out.println("Distinct Elements in the array : "+hs.size());
    }
}