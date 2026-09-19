// Write a function to compute the sum of the given integer.


import java.util.*;
public class digi_sum{
    public static void sum(int n){
        int s=0;
        while(n!=0){
            int r=n%10;
            s=s+r;
            n=n/10;
        }
        System.out.println("The sum of the digit is : "+s);
    }



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sum(n);
    }
}