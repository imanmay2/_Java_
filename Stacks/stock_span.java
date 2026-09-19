// Write a program that will calculate the Stock of the company. And display the span array.

import java.util.*;
public class stock_span{
    public static void calc_Stock(int[] arr,int[] span){
        Stack<Integer> st=new Stack<>();
        st.push(0);
        span[0]=1;
        for(int i=1;i<span.length;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i]=i-st.peek();
                st.push(i);
            }
        }
    }
    public static void main(String args[]){
        int[] arr={100,80,60,70,60,85,100};
        int[] span=new int[arr.length];
        calc_Stock(arr,span);

        // printing the span array.
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]+" ");
        }
    }
}