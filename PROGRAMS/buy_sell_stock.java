// You are given an array prices where prices[i] is the price of a given stock on
// the ith day.
// Return the maximum profit you can achieve from this transaction. If you cannot
// achieve any profit, return 0.



import java.util.*;
public class buy_sell_stock{
    public static int min(int[] arr,int idx){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<idx;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }



    public static int profit(int[] arr){
        int pro=0;
        for(int i=1;i<arr.length;i++){
            int sp=arr[i];
            int bp=min(arr,i);
            int p=sp-bp;    //storing the profit
            if(p<0){
                p=0;
            }

            else if(pro<p){
                pro=p;
            }
            
        }
        return pro;
    }



    public static void main(String args[]){
        int[] arr={7,1,5,3,6,4};
        System.out.println("The Maximum Profit of the STOCK is : "+ profit(arr));

    }
}