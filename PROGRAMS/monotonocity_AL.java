// Write a function that will check whether it is monotonic or not...


import java.util.*;
public class monotonocity_AL{
    public static boolean check_monotonic(ArrayList<Integer> list){
        int check;  
        if(list.get(0)>list.get(1)){
            check=1;
        }
        else{
            check=0;
        }
        
        for(int i=1;i<list.size()-1;i++){
            if(check==1 && list.get(i)>list.get(i+1)){
                check=1;
            }
            else if(check==0 && list.get(i)<list.get(i+1)){
                check=0;
            }
            else if(list.get(i)==list.get(i+1)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the range of the ArrayList : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the number to be inserted : ");

            list.add(sc.nextInt());
        }
        System.out.print(check_monotonic(list));

    }
}