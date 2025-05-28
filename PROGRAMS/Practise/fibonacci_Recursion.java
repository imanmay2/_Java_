import java.util.Scanner;
public class fibonacci_Recursion {
    public static int fibonacci(int n){
        int sum=0;
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        }
        sum=fibonacci(n-1)+fibonacci(n-2);
        return sum;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();

        System.out.println("Fibonacci of nth term is: "+fibonacci(n));
    }
}
