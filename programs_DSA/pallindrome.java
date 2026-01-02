//WAP to check whther a entered number is pallindrome or not.
import java.util.*;
public class pallindrome{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number to check whether the entered number is pallindrome or not");
        int n=sc.nextInt();
        int rev=0,t=n;
        int r;
        while(n!=0){
            r=n%10;
            rev=(rev*10)+r;
            n=n/10;
        }
        if(t==rev){
            System.out.print(t+" is a pallindrome number");
        }
        else{
            System.out.print(t+" is not a palindrome number");
        }
    }
}