// Write a program that will calculate the Stock of the company. And display the span array.

import java.util.*;
public class stock_span{

    public static void calc_Stock(int[] arr,int[] span){
        Stack<Integer> st=new Stack<>();
        int i=0;
        span[i]=1;
        st.push(i);
        while(!st.isEmpty()){
            i++;
            if(i==arr.length-1){
                span[i]=i+1;
            }
            else if(arr[st.peek()]>arr[i]){
                span[i]=i-st.peek();
                st.push(i);
            }
            else if(arr[st.peek()]<arr[i]){
                st.pop();
            }
        }

    }
    public static void main(String args[]){
        int[] arr={100,80,60,70,60,85,100};
        int[] span=new int[arr.length];
        calc_Stock(arr,span);

        //printing the span array.
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]+" ");
        }
    }
}