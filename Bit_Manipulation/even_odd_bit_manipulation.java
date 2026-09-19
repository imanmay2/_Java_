// WAP that will check whether the number is even or odd.,..via bits manipulation.


import java.util.*;
public class even_odd_bit_manipulation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number respectively: ");
        int n1=sc.nextInt();
        if((n1 & 1)==0){
            System.out.print("Number is even");
        }
        else if((n1 & 1)==1){
            System.out.print("Number is odd");
        }
    }
}