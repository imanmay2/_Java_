//Write a program that reads a set of integers ,and then prints the sum of the even and odd integers
import java.util.*;
public class sum_even_odd{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter how many nnumber you wanna enter : ");
        int n=sc.nextInt();
        int s_eve=0;
        int s_odd=0;
        for(int i=0;i<n;i++){
            System.out.println("Enter the number : ");
            int ele=sc.nextInt();
            if(ele%2==0){
                s_eve=s_eve+ele;
            }
            else{
                s_odd=s_odd+ele;
            }
        }
        System.out.println("Sum of even and odd respectively are as follows : "+s_eve+","+s_odd);

    }

    
}