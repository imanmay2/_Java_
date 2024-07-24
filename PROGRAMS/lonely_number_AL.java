// Find lonely number from the arrayList...given..

import java.util.*;
public class lonely_number_AL{
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range of the ArrayList : ");
        int n=sc.nextInt();


        //Adding elements in the ArrayList...
        for(int i=0;i<n;i++){
            System.out.println("Enter the number to be inserted : ");
            list.add(sc.nextInt());
        }


        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i==j){
                    continue;
                }
                else{
                    if((list.get(i)+1)==list.get(j) || (list.get(i)-1)==list.get(j) || list.get(i)=y=list.get(j)){
                        System.out.print(list.get(i)+" ");
                    }
                    // else{
                    //     System.out.print(list.get(i)+" ");
                    // }
                }
            }
        }

    }
}