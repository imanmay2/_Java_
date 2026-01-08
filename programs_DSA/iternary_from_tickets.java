import java.util.*;

public class iternary_from_tickets {

    public static HashMap<String,String> reverseHM(HashMap<String,String> tickets){
        HashMap<String,String> hm=new HashMap<>();
        Set<String> set=tickets.keySet();
        for(String str:set){
            hm.put(tickets.get(str),str);
        }

        return hm;
    }

    public static String  startPoint(HashMap<String,String> tickets,HashMap<String,String> rhm){
        // using the concept of O(n) complexity.
        for(String str:tickets.keySet()){
            if(!rhm.containsKey(str)){
                return str;
            }
        }
            return "exists";  
    }

    public static void printCities(String str,HashMap<String,String> tickets){
        for(String s:tickets.keySet()){
            
        }
    }


    public static void main(String args[]){
        HashMap<String,String> tickets=new HashMap<>();
        tickets.put("C","B");
        tickets.put("M","D");
        tickets.put("G","C");
        tickets.put("D","G");


    }
}
