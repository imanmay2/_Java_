// WAP that will input a number from the user and display its factorial.


import java.util.*;
public class factorial{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int num=sc.nextInt();
        int fact=1;
        for(int i=1;i<=num;++i){
            fact=fact*i;
        }

        System.out.println("The Factorial of the number is : "+fact);

    }
}