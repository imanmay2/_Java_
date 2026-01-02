import java.util.*;
public class next_greater_element {
    public static void greater_ele(int[] arr){
        Stack<Integer> s=new Stack<>();
        int[] nextGreater=new int[arr.length];
        int j=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[j]=-1;
                j--;
            }
            else{
                nextGreater[j]=s.peek();
                j--;
            }
            s.push(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
    public static void main(String args[]){
        int[] arr={6,8,0,1,3};
        greater_ele(arr);
    }
}
