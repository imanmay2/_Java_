// Write a program in java that will print the maximum from the array list.



import java.util.*;
public class maximum_arrayList{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array list : ");
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            System.out.println("Enter the number to be inserted : ");
            list.add(sc.nextInt());
        }


        //main algo..

        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            maxi=Math.max(maxi,list.get(i));
        }
        System.out.print("The maximum of the ArrayList is : "+ maxi);
    }
}