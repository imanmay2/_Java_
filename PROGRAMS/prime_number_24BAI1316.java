import java.util.Scanner;
public class prime_number_24BAI1316 {

    public static boolean checkPrime(int n){
        int ct=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                ct++;
            }
        } if(ct==2){
            return true;
        }return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num=sc.nextInt();

        if(checkPrime(num)){
            System.out.println(num+" is a prime number");
        } else{
            System.out.println(num+" is not a prime number");
        }
    }
}

