// Write a program that will get the MAXIMUM water stored int he container (ARRAYLIST).

import java.util.*;
public class max_Water_Container{
    public static int calc_Max(ArrayList<Integer> list,int width){
        int max=Integer.MIN_VALUE;
        int m=0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                m=((j-i)*(Math.min(list.get(i),list.get(j)))*width);
                if(m>max){
                    max=m;
                }
            }
        }
        return max;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the number to be added : ");
            list.add(sc.nextInt());
        }

        System.out.print("Maximum water conatining is : "+ calc_Max(list,1));

    }
}