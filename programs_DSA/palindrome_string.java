//WAP that will print the string is palindrome or not..


import java.util.*;
public class palindrome_string{
    public static void main(String args[]){
        String str1=new String("racecar");
        int f=0;
        for(int i=0;i<(str1.length()/2);i++){
            int n=str1.length();
            if(str1.charAt(i)!=str1.charAt((n-i-1))){
                f=1;
                break;
            }
        }
        if(f==1){
            System.out.print("Word is not Palindrome");
        }
        else if(f==0){
            System.out.print("Word is Palindrome");
        }
    }
}




public class palindrome_string{
    public static void main(String args[]){
        String str=new String("racecar");
        String s=new String("");;
        for(int i=str.length()-1;i>=0;i--){
            s=s+str.charAt(i);
        }


        // System.out.print(s+" "+str);

        if(s.equals(str)){
            System.out.print("Word is Palindrome");
        }
        else{
            System.out.println("Word is not Palindrome");
            System.out.print(s+" "+str);
        }
    }
}