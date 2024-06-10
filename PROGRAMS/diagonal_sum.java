//WAP that will print the diagonal sum of the 2D-matrix array.


import java.util.*;
public class diagonal_sum{
    public static void main(String args[]){
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int s=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==j || i+j==arr.length-1){
                    s+=arr[i][j];
                }
            }
        }
        System.out.print("The sum of the diagonals of the matrix are : "+ s);
    }
}