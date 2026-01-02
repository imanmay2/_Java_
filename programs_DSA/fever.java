// Check whether a person is aving fever or not


import java.util.*;
public class fever{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        float temp=sc.nextFloat();
        if(temp=>100){
            System.out.println("Person has fever!");
        }
        else if(temp<100){
            System.out.println("Person is not having fever!");
        }
    }
}