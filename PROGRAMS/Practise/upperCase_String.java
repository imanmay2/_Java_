import java.util.Scanner;

public class upperCase_String {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();
        System.out.println("String converted to: "+str.toUpperCase());
    }
}
