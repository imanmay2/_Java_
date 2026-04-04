import java.util.*;

public class union_intersection_HS {
    public static void printUnion(int arr1[],int arr2[]){
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }

        for(int i:hs){
            System.out.print(i+" ");
        }

        System.out.println();
    }

    public static void printIntersection(int arr1[],int arr2[]){
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);

        }

        //now traversing in the arr2
        for(int i=0;i<arr2.length;i++){
            if(hs.contains(arr2[i])){
                System.out.print(arr2[i]+" ");
                hs.remove(arr2[i]);
            }
        } System.out.println();
    }
    public static void main(String args[]){
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        

        //union 
        System.out.print("Union are : ");
        printUnion(arr1, arr2);


        //intersection
        System.out.print("Intersection are : ");
        printIntersection(arr1, arr2);
    }
}
