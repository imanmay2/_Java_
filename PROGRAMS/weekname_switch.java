//Write a Java program to input week number(1-7) and print day of week name using switch case.

import java.util.*;
public class weekname_switch{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number from 1-7: ");
        int n=sc.nextInt();
        switch(n){
            case 1:{
                System.out.print("Sunday");
                break;
            }
            case 2:{
                System.out.print("Monday");
                break;
            }
            case 3:{
                System.out.print("Tuesday");
                break;
            }
            case 4:{
                System.out.print("Wednesday");
                break;
            }
            case 5:{
                System.out.print("Thrusday");
                break;
            }
            case 6:{
                System.out.print("Friday");
                break;
            }
            case 7:{
                System.out.print("Saturday");
                break;
            }
            default:
                System.out.print("Invalid Number entered !! Please Try entering from 1-7");
        }
    }
}