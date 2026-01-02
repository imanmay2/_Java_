// Write a program  that will print the largest string from an array in leximographic way.



import java.util.*;
public class largest_string{
    public static void main(String args[]){
        String arr[]={"apple","mango","banana"};
        String fruit="";
        for(int i=0;i<arr.length;i++){
            if(arr[i].compareToIgnoreCase(fruit)>0){
                fruit=arr[i];
            }
        }
        System.out.print("The largest String is : "+ fruit);
    }
}