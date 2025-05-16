import java.util.Scanner;
public class prime_check{

    public static boolean checkPrime(int n){
        int ct=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                ct++;
            }
        } if(ct==2){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num=sc.nextInt();  // taking input from the user.
        if(checkPrime(num)){
            System.out.println("Number "+num+" is Prime");
        } else {
            System.out.println("Number "+num+" is Composite");
        }
    }
}