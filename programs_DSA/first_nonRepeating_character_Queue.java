import java.util.ArrayDeque;
import java.util.Queue;

public class first_nonRepeating_character_Queue{

    public static void nonRepeatingSeries(String str){
        int arr[]=new int[26];
        Queue<Character> q1=new ArrayDeque<>();


        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            arr[s-'a']++;
            q1.add(s);
            if(!q1.isEmpty() && arr[q1.peek()-'a']<=1){
                System.out.print(q1.peek()+" ");
            } else{
                // System.out.print("-1 ");
                // q1.remove();
                while(!q1.isEmpty() && arr[q1.peek()-'a']>1){
                    q1.remove();
                }if(q1.isEmpty()){
                    System.out.print("-1 ");
                    continue;
                }
                 System.out.print(q1.peek()+" ");
            }
        }
    }
    public static void main(String args[]){
       String str="aabccxb";
       nonRepeatingSeries(str);
    }
}