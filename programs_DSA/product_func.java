// Write a function in java that will calculate the product of 2 numbers.
import java.util.*;
public class product_func{
    public static int product(int n1,int n2){
        return n1*n2;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 2 numbers : ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("The product of the 2 numbers : "+product(a,b));
    }
}