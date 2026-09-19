// WAP that will check whether the entered number is even or odd.
import java.util.*;
public class even_odd_bits_manipulation{
    public static void check(int n){
    if((n&1)==0){
        System.out.println("Number is Even");
    }
    else if((n&1)==1){
        System.out.println("Number is Odd");
    }
    }

    public static void main(String args[]){
        check(2);
        check(3);
    }
}