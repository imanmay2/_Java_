// Write a program that will compress the string..
//          E.g-- aaaabbcc
//                output : a4b2c2.




import java.util.*;
public class string_compression{
    public static String compress(String str){
        String newStr="";
        for(int i=0;i<str.length();i++){
            Integer ct=1;
            newStr+=str.charAt(i);
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                ct++;
                i++;
            }
            if(ct>1){
                newStr+=ct.toString();
            }
        }
        return newStr;
    }




    public static void main(String args[]){
        String str="aaabbc";
        System.out.print(compress(str));
    }
}