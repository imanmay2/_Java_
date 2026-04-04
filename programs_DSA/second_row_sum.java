//Print out the sum of the numbers in the second row of the “nums” array.


import java.util.*;
public class second_row_sum{
    public static void main(String args[]){
        int s=0;
        int[][] arr= {{1,4,9},{11,4,3},{2,2,3} };
        for(int i=0;i<arr[1].length;i++){
            s+=arr[1][i];
        }

        System.out.print("The sum of the 2nd row of the 2D-array is : "+ s);
        
    }

}