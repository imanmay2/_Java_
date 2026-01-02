import java.util.*;
public class check_prime{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int n= sc.nextInt();
        int ct=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                ct++;
            }
        }
        if(ct==2){
            System.out.println(n+" is Prime");
        }
        else{
            System.out.println(n+" Is not Prime");
        }
    }
}