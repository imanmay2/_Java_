// Display the lonely numbers from the arraylist.
//You are given an integer arraylist nums.A number x is lonely when it appears only once,and 
//no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.


import java.util.*;
public class lonely_number_AL{

    public static boolean check(ArrayList<Integer> list,int num){
        for(int i=0;i<list.size();i++){
            if(num==list.get(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Range : ");
        int n=sc.nextInt();
        //Accepting input from the user .
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the num : ");
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        ArrayList<Integer> list_=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(i==list.size()-1 && (list.get(i)-list.get(i-1)==0 || list.get(i)-list.get(i-1)==1 || list.get(i)-list.get(i-1)==-1)){
                continue;
            }
            else if(list.get(i)-list.get(i+1)==1 || list.get(i)-list.get(i+1)==-1 || list.get(i)-list.get(i+1)==0 || list.get(i)-list.get(i-1)==1 || list.get(i)-list.get(i-1)==-1 || list.get(i)-list.get(i-1)==0){
                continue;
            }
            else{
                if(!check(list_,list.get(i))){
                    list_.add(list.get(i));
                }
            }
        }
        System.out.println("The Lonely Numbers are : ");
        System.out.println(list_);
}
}