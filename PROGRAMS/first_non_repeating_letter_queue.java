// First non-repeating letter in a stream of character using Queue.
//e.g : a a b c c x b 
// Output : a -1 b b b b x. 

import java.util.*;
public class first_non_repeating_letter_queue{

    public static char func_(String str){
        Queue<Character> q1=new ArrayDeque<>();
        char[] arr=new char[26];
        char s_;
        q1.add(str.charAt(0));
        arr[str.charAt(0)-'a']++;
        s_=str.charAt(0);
        for(int i=1;i<str.length();i++){
            q1.add(str.charAt(i));
            arr[str.charAt(i)-'a']++;
            while(arr[q1.peek()-'a']>1 && !q1.isEmpty()) {
                q1.remove();
            }
            if(!q1.isEmpty()){
                s_=(char) (s_+q1.peek());
            }
        }
        return s_;
        
    }
    public static void main(String args[]){
        String str=new String("aabccxb");
        System.out.println(func_(str));
    }
}
