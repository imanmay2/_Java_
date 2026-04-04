//Write a Java program that takes a year from the user and print whether that year is a leap year or not.


import java.util.*;
public class leap_year{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year=sc.nextInt();
        if(year%4==0){
            if(year%100==0 && year%400==0){
                System.out.print(year+" is a leap year");
            }
            else if(year%100!=0){
                System.out.print(year+" is a leap year");
            }
            else{
                System.out.print(year+" is not a leap year");
            }
        }
        else{
            System.out.print(year+" is not a leap year");
        }
    }
}