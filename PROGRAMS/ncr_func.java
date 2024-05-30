// Write a function to calculate the binomial coefficient ncr 

import java.util.*;
public class ncr_func{
    public static int fact(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the values of n and r : ");
        int n=sc.nextInt();
        int r=sc.nextInt();
        System.out.println("The binomial coefficient is  : "+ (fact(n)/(fact(n-r)*fact(r))));
    }
}