import java.util.*;
public class exception_handling {

    public static void checkAge(int age) throws ArithmeticException,NullPointerException{
        if(age==0){
            throw new NullPointerException("Age can't be 0");
        }
        else if(age<18){
            throw new ArithmeticException("Age can't be less than 18");
        } else{
            System.out.println("Age is above 18.");
        }
    }
    public static void main(String args[]){
        try{
            int num=5/0;
        } catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
        } finally{
            try{
                checkAge(20);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Finally block executed.");
        }
        System.out.println("Here is the code after handling the exception.");
    }
}
