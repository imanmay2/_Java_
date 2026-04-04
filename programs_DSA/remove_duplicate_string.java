// WAP that will remove the duplicate elements from the string..


import java.util.*;
public class remove_duplicate_string{
    public static String remove(String str){
        int idx;
        char chr;
        StringBuilder sb=new StringBuilder("");
        boolean[] arr=new boolean[26];
        for(int i=0;i<str.length();i++){
            chr=str.charAt(i);
            int char_arr=chr-'a';
            if(arr[char_arr]==false){
                sb.append(chr);
                arr[char_arr]=true;
            }
        }
        return sb.toString();
    }


    public static String remove_recursion(String str,int i,boolean arr[],StringBuilder sb){
        char chr;
        if(i==str.length()){
            return sb.toString();
        }
        chr=str.charAt(i);
        int char_arr=chr-'a';
        if(arr[char_arr]==false){
            sb.append(chr);
            arr[char_arr]=true;
        }

        return remove_recursion(str,i+1,arr,sb);

    }



    public static void main(String args[]){
        StringBuilder sb=new StringBuilder("");
        boolean[] arr=new boolean[26];
        System.out.print(remove_recursion("appnacollege",0,arr,sb));
    }
}