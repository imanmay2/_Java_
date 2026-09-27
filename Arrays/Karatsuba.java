import java.util.*;

public class Karatsuba(){
    public static long recur(long x,long y){
        if(x<10 || y<10){
            return x*y;
        }

        int n=Math.max(Long.toString(x).length(),Long.toString(y).length());
        int m=n/2;

        long p=(long)Math.pow(10,m);
        //separate digits. 
        long a=x/p;
        long b=x%p;
        long c=y/p;
        long d=y%p;
        long ac=recur(a,c);
        long bd=recur(b,d);
        long abcd=recur(a+b,c+d);
        return p*p*ac+p*(abcd-ac-bd)+bd;
    }

    public static void main(String args[]){
        long x;
        long y;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number 1 : ");
        x=sc.nextLong();
        System.out.println("Enter the number 2 : ");
        y=sc.nextLong();

        System.out.println("Multiplication Result is : ",recur(x,y));
    }
}