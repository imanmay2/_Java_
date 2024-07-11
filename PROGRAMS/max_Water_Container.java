// Write a program that will get the MAXIMUM water stored int he container (ARRAYLIST).

import java.util.*;
public class max_Water_Container{
    public static int calc_Max(ArrayList<Integer> list,int width){
        int max=Integer.MIN_VALUE;
        int m=0;


        //Time Complexity : O(n^2).
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

    public static int optimized_Max(ArrayList<Integer> list,int width){
        int m=0;


        //Time Complexity: O(n).
        int lp=0;
        int rp=list.size()-1;
        while(lp<rp){
            m=Math.max(m,(rp-lp)*(Math.min(list.get(rp),list.get(lp)))*width);
            if(list.get(lp)<list.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return m;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the number to be added : ");
            list.add(sc.nextInt());
        }

        System.out.println("Maximum water conatining is : "+ calc_Max(list,1));
        System.out.print("Maximum water conatining is : "+ optimized_Max(list,1));

    }
    }
