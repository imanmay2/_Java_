// tilling problem


import java.util.*;
public class tilling_problem{
    public static int tilling(int n){
        //base cases
        if(n==0 || n==1){
            return 1;
        }
        return tilling(n-1)+tilling(n-2);
    }


    public static void main(String args[]){
        System.out.println("Number of ways are : " + tilling(2));
    }
}