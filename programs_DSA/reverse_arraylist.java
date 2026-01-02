// Write a program that will print the reverse of the arraylist.


import java.util.*;
public class reverse_arraylist{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the list : ");
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            System.out.print("Enter the number to be inserted : ");
            list.add(sc.nextInt());
        }


        //Reversing the ArrayList.
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }
}