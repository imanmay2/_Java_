// Input 3 numbers from the user and display the average of the numbers.


import java.util.*;
public class avg_number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        float s;
        System.out.println("Enter the 3 numbers : ");
        float a=sc.nextFloat();
        float b=sc.nextFloat();
        float c=sc.nextFloat();
        s=(a+b+c)/3;
        System.out.println("Average of 3 numbers is : "+s);
    }
}
