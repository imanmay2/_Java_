// WAP that will print the reverse of the number.



import java.util.*;
public class reverse_number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
        int rev=0;
        while(n!=0){
            int r=n%10;
            rev=rev*10+r;
            n=n/10;
        }

        System.out.println("The reverse of the number is : "+rev);
    }
}