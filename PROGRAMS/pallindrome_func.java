// Write a function that will check whether the number is pallindrome or not.


import java.util.*;
public class pallindrome_func{
    public static boolean check_pallindrome(int n){
        int rev=0;
        int num=n;
        while(n!=0){
            int r=n%10;
            rev=(rev*10)+r;
            n=n/10;
        }
        if(rev==num){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
        if(check_pallindrome(n)){
            System.out.println("Number is pallindrome");
        }
        else{
            System.out.println("Number is not pallindrome");
        }
    }
}
