// Display the prime numbers in a range.

import java.util.*;
public class prime_range{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int s=sc.nextInt();
        int e=sc.nextInt();
        for(int i=s;i<=e;i++){
            int ct=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    ct++;
                }
            }
            if(ct==2){
                System.out.println(i);
            }
        }
    }
}