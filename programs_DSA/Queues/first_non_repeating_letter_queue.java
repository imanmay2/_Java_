// First non-repeating letter in a stream of character using Queue.
//e.g : a a b c c x b 
// Output : a -1 b b b b x. 

import java.util.*;
import java.util.LinkedList;
public class first_non_repeating_letter_queue{
    public static void func_(String str){
        Queue<Character> q1=new LinkedList<>();
        int[] arr=new int[26];
        q1.add(str.charAt(0));
        arr[str.charAt(0)-'a']++;
        System.out.print(q1.peek()+" ");
        for(int i=1;i<str.length();i++){
            char ch=str.charAt(i);
            q1.add(ch);
            arr[ch-'a']++;
            while(!q1.isEmpty() && arr[q1.peek()-'a']>1){
                q1.remove();
            }
            if(q1.isEmpty()){
                System.out.print("-1 ");
                continue;
            }
            System.out.print(q1.peek()+" ");
        }
    }
    public static void main(String args[]){
        String str="aabccxb";
        func_(str);
    }
}
