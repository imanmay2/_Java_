// WAP that will print the multiplication table of a given number inputted by the user.


import java.util.*;
public class multiplication_table{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number  : ");
        int n=sc.nextInt();
        System.out.println("The multiplication table of "+n+" is" );
        for(int i=1;i<=n;i++){
            System.out.println(n+"*"+i+"="+(n*i));
        }
    }
}