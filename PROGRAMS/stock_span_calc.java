// Write a program that will calculate the Stocks of the company...


import java.util.*;
public class stock_span_calc{
    public static void stock_span(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] span=new int[arr.length];
        span[0]=1;    //by default...
        st.push(0);
        for(int i=1;i<arr.length;i++){
            int idx=st.peek();
            while(!(arr[idx]>arr[i])){
            }
        }
    }
    public static void main(String args[]){
        int[] arr={100,80,60,70,60,85,100};
        
    }
}