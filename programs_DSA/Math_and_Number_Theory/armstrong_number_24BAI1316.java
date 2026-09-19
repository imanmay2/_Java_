import java.util.Scanner;

public class armstrong_number_24BAI1316 {
    public static boolean checkArmstrong(int n){
        int sum=0;
        int num=n;
        while(n!=0){
            int r=n%10;
            sum=sum+(r*r*r);
            n=(int)n/10;
        }

        if(num==sum){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num=sc.nextInt();

        if(checkArmstrong(num)){
            System.out.println(num+" is an Armstrong Number.");
        } else{
            System.out.println(num+" is not an Armstrong Number.");
        }
    }
}
