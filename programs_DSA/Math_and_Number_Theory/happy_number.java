//WAP to check wheather a number entered by the user is happy or sad.
import java.util.*;
public class happy_number{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the number to check wheather it is a happy number or a sad number");
        n=sc.nextInt();
        int p=0;
        if(n>0 && n<10){
            System.out.println(n+" is a sad number");
        }
        else{
            while(true){
                int s=0;
                while(n>0){
                    int r=n%10;
                    s+=(r*r);
                    n=n/10;
                }
                if(s<10){
                    p=s;
                    break;
                }
                else{
                    n=s;
                }

            }
            if(p==1){
                System.out.println(n," is a happy number");
            }
            else{
                System.out.println(n+" is a sad number");
            }
        }
    }
}