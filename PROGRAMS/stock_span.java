// Write a Program that will display the stock.

import java.util.*;
public class stock_span{
    public static void calc_stock(int[] arr,int[] span){
        Stack<Integer> st=new Stack<>();
        span[0]=1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[st.peek()]){
                st.push(i);
                span[i]=i-st.peek();
            }
            
        }
    }
    public static void main(String args[]){
        int[] arr={100,80,60,70,60,85,100};
        int[] span=new int[arr.length];
        calc_stock(arr,span);
    }
}