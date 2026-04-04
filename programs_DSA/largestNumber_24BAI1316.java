import java.util.Scanner;

public class largestNumber_24BAI1316 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        int res=((a>b)?((a>c)?a:c):((b>c)?b:c));

        System.out.println("Largest number among "+a+","+b+","+c+" is "+res);
    }
}
