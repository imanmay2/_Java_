import java.util.Scanner;

public class substring {

    public static String subString(String str,int si,int ei){
        String substring=new String();
        for(int i=si;i<ei;i++){
            substring=substring+str.charAt(i);
        }

        return substring;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str=sc.nextLine();
        System.out.println("Substring is: "+str.substring(2,5));
    }
}
