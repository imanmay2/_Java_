public class fibonaaciRecursion {

    public static int Fibonacci(int n){
        if(n==1){
            return 1;
        } else if(n==0){
            return 0;
        }

        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main(String args[]){
        int n=6;
        System.out.println("Nth term of the fibonacci series is: "+Fibonacci(n));
    }
}