import java.util.*;
public class factorial_recursion{
    public static int fact(int num){
        int f=1;
        if(num==0){
            return 1;
        }
        f=num*fact(num-1);
        return f;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.print("Factorial of the number is : ");
        System.out.print(fact(num));
    }
}