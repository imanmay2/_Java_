// Write a program that will calculate the Stocks of the company...

import java.util.*;
public class stock_span_problem{
    public static void calculate_stock(ArrayList<Integer> list){
        ArrayList<Integer> span=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<list.size();i++){
            if(i==0){
                s.push(i);
                span.add(1);
            }
            else if(i==list.size()-1){
                s.push(i+1);
                span.add();
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(100);
        list.add(80);
        list.add(60);
        list.add(70);
        list.add(60);
        list.add(85);
        list.add(100);
        calculate_stock(list);
    }
}