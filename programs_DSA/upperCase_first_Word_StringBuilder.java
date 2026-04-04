import java.util.Scanner;

public class upperCase_first_Word_StringBuilder {

    public static String convertString(String str){
        StringBuilder sb=new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)==' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
                continue;
            }
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str=sc.nextLine();

        System.out.println(convertString(str));
    }
}
