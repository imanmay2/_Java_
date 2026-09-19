import java.util.Scanner;

public class pallindromeString {

    public static boolean checkPallindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(!(str.charAt(left)==str.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str=sc.nextLine();

        if(checkPallindrome(str)){
            System.out.println("String is pallindrome");
        } else {
            System.out.println("String is not pallindrome.");
        }
    }
}
