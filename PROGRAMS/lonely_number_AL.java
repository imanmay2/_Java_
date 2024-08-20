// Display the lonely numbers from the arraylist.
//You are given an integer arraylist nums.A number x is lonely when it appears only once,and 
//no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.


import java.util.*;
public class lonely_number_AL{
    public static ArrayList lonely_num(ArrayList<Integer> arr){
        ArrayList<Integer> arr_=new ArrayList<>();
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            if(i==0 && arr.get(i+1)!=arr.get(i)+1){
                arr_.add(arr.get(i));
            }
            else if(i==arr.size()-2 && arr.get(i+1)!=arr.get(i)+1 && arr.get(i-1)!=arr.get(i)-1){
                arr_.add(arr.get(i));
            }
            else if(arr.get(i+1)!=arr.get(i)+1 && arr.get(i-1)!=arr.get(i)-1){
                 arr_.add(arr.get(i));
            }
        }
        return arr_;
    }



    public static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Range of the ArrayList : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the number : ");
            arr.add(sc.nextInt());
        }
        System.out.println();
        System.out.println(lonely_num(arr));
    }
}