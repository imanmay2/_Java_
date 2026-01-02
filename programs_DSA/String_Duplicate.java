import java.util.Scanner;

public class String_Duplicate {

    public static String check(String str,int i,boolean arr[], StringBuilder sb){
        if(i==str.length()){
            return sb.toString();
        }

        if(!arr[(str.charAt(i)-'a')]){
            arr[(str.charAt(i)-'a')]=true;
            sb.append(str.charAt(i));
        }

        return check(str, i+1, arr,sb);
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String str=sc.nextLine();
        boolean arr[]=new boolean[26];
        System.out.println(check(str, 0, arr,sb));
    }
}
