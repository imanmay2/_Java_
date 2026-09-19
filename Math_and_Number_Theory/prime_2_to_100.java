// Print prime numbers from 2 to 100.


public class prime_2_to_100{
    public static void main(String args[]){
        System.out.println("Prime numbers are : ");
        for(int i=2;i<=100;i++){
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
