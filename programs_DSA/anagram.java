import java.util.*;

public class anagram {
    public static HashMap<Character,Integer> Anagram_1(String str1,HashMap<Character,Integer> hm){
        for(int i=0;i<str1.length();i++){
            if(hm.containsKey(str1.charAt(i))){
                int val=hm.get(str1.charAt(i));
                hm.put(str1.charAt(i),++val);
            }else{
                hm.put(str1.charAt(i),1);
            }
        }
        return hm;
    }

    public static boolean Anagram_2(String str,HashMap<Character,Integer> hm){
        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                int val=hm.get(str.charAt(i));
                hm.put(str.charAt(i),--val);
                if(val==0){
                    hm.remove(str.charAt(i));
                }
            }else{
                return false;
            }
        } return true;
    }


    public static void main(String args[]){
        HashMap<Character,Integer> hm=new HashMap<>();
        String str1=new String("knee");
        String str2=new String("keet");

        hm=Anagram_1(str1,hm);

        if(Anagram_2(str2, hm) && hm.isEmpty()){
            System.out.println("Strings are anagram...");
        }else{
            System.out.println("Strings are not anagram...");
        }
    }
}
