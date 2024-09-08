// Display the lonely numbers from the arraylist.
//You are given an integer arraylist nums.A number x is lonely when it appears only once,and 
//no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.


import java.util.*;
public class lonely_number_AL{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Range : ");
        int n=sc.nextInt();
        //Accepting input from the user .
        for(int i=0;i<n;i++){
            System.out.println("Enter the num : ");
            int num=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>();
        // Collections.sort(list);

        ArrayList<Integer> list_=new ArrayList<>();

        //tarversing the array.
        for(int i=0;i<list.size()-1;i++){
            if(i==0 && (list.get(i)+1==list.get(i+1) || list.get(i)-1 ==list.get(i+1) || list.get(i) ==list.get(i+1))){
                continue;
            }
            else if(i==list.size()-2 && (list.get(i)+1==list.get(i+1)  || list.get(i)-1==list.get(i+1) || list.get(i)==list.get(i+1))){
                continue;
            }
            else if(list.get(i)==list.get(i+1) || list.get(i)==list.get(i-1) || list.get(i)+1==list.get(i+1) || list.get(i)+1==list.get(i-1) || list.get(i)-1==list.get(i-1) || list.get(i)-1==list.get(i+1)){
                continue;
            }
            else{
                list_.add(list.get(i));
            }
        }
        System.out.println("The ArrayList is as follows : ");
        System.out.println(list_);
    }
}