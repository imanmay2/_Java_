// Trying out the practical implementation of method scope.


import java.util.*;
public class scope{
    public static void main(String args[]){
        //method scope.
        System.out.println(s);
        int s=20;




        //block scope.
        {
            int s=20;
        }
        System.out.println(s);
    }
}