// Write a Java method to compute the average of three numbers..


import java.util.*;
public class avg_func{
    public static void avg_num(int a,int b,int c)
    {
        System.out.println("The average of the 3 numbers is : "+(a+b+c)/3);
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 3 numbers : ");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        avg_num(n1,n2,n3);
    }
}