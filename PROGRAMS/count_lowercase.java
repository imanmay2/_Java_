// Accept a String and count the lowercase characters entered by the user.


import java.util.*;
public class count_lowercase{
    public static int count(String str){
        int ct=0;
        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                ct++;
            }
        }
        return ct;
    }



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str=sc.nextLine();
        System.out.println("The Count of the LowerCase is : "+ count(str));
    }
}