// WAP that will calculate the power of x using recursion..


import java.util.*;
public class calculate_power_x{
    public static int calculate(int x,int n){
        if(n==0){
            return 1;
        }
        return x*(calculate(x,n-1));
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int x=sc.nextInt();
        System.out.println("Enter the power : ");
        int n=sc.nextInt();
        System.out.println(calculate(x,n));
    }
}