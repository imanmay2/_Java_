import java.util.*;
public class positive_negative{
    public static void main(String args[]){
        System.out.println("Enter the number : ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num>0){
            System.out.print(num+" is positive");
        }
        else if(num<0){
            System.out.print(num+" is negative");
        }
        else{
            System.out.print(num+" is Neutral");
        }
    }
}