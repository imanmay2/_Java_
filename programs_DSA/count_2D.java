// WAP that will count the 7's in the 2D array.


import java.util.*;
public class count_2D{
    public static void main(String args[]){
        int[][] arr= {{4,7,8},{8,8,7} };
        int key=7;
        int ct=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    ct++;
                }
            }
        }
        System.out.print("The Number of 7's from the 2D array is : "+ ct);
    }
}