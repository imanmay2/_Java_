import java.util.*;

public class count_distinct_element {
    public static void main(String args[]){
        int arr[]={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hs=new HashSet<>();
        for(Integer i:arr){
            hs.add(i);
        }

        System.out.println("Distinct element : "+hs.size());
    }
}
