import java.util.*;
public class function_of_string{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name please");
        String name=sc.next();
        System.out.println("Length of "+name+"is "+name.length());
        System.out.println("Character of the present index is as follows "+name.charAt(0));
        System.out.println("New string after being replaced is as follows "+name.replace("M","m"));
        System.out.print("Substring is as follows"+name.substring(0,4));
    }
}