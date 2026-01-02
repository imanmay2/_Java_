 
 //WRITE A PROGRAM THAT WILL CONVERT CHARACTER TO INTEGER (TYPECASTING)..


 import java.util.*;
 public class convert_char_int{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Integer character : ");
        char ch=sc.next().charAt(0);
        System.out.print("The converted Integer value is : "+ (ch-'0'));
    }
 }