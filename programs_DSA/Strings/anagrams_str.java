// Determine if 2 Strings are anagrams of each other.
// What are anagrams?
// If two strings contain the same characters but in a different order, 
//they can be said to be anagrams. Consider race and care. 
//In this case, race's characters can be formed into a study, 
//or care's characters can be formed into race. 




import java.util.*;
public class anagrams_str{
    public static String anagram(String str1){
        char arr1[]=str1.toCharArray();
        Arrays.sort(arr1);
        return new String(arr1);
    }




    public static void main(String str[]){
        String str1="race";
        String str2="care";
        String s1=anagram(str1);
        String s2=anagram(str2);
        // System.out.println(anagram(str1)+" "+anagram(str2));
        if(s1.equals(s2)){
            System.out.print("Yes, Two Strings are anagrams!!!");
        }
        else{
            System.out.print("No, They are not anagrams!!!");
        }
    }
}