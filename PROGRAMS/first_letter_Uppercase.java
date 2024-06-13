// Write a program, that will convert the first letter of the word to Uppercase.



import java.util.*;
public class first_letter_Uppercase{
    public static String upper(String str){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(Character.toUpperCase(str.charAt(i+1)));
            }
            // else if(str.charAt(i)==' ' && str.charAt(i-1)!=' '){
            //     sb.append(str.charAt(i));
            // }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
        
     }

    public static void main(String args[]){
        System.out.print(upper("germany france netherland luxembourg spain"));
    }
}