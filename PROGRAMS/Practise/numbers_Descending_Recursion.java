import java.util.Scanner;
public class numbers_Descending_Recursion {

    public static int printDescending(int n){
        if(n==1){
            System.out.print(1);
            return 1;
        } else if(n==0){
            System.out.print(0);
            return 0;
        }

        
        printDescending(n-1);
        System.out.print(n);
        return 0;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        printDescending(n);
    }
}
