// Monotonic ArrayList ---- Accept a ArrayList from the user and return True if it's monotonically decreasing or increasing.

import java.util.*;
public class monotonic_AL {
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Range of the ArrayList : ");
        int n=sc.nextInt();

        // Accepting element from the user.
        for(int i=0;i<n;i++){
            System.out.println("Enter number : ");
            int num=sc.nextInt();
        }


        //traversing thorough the array.
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<list.size()-1-1;i++){
            if(list.get(i)>list.get(i+1)){
                inc=false;
            }
            else if(list.get(i)<list.get(i+1)){
                dec=false;
            }
        }

        System.out.println((inc || dec));
    }
}
