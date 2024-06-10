// WAP that will print the @D-matrix in  a spiral order.


import java.util.*;
public class spiral_matrix{
    public static void main(String args[]){
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int start_row=0;
        int end_row=arr[0].length-1;
        int start_col=0;
        int end_col=arr[0].length-1;

        while(start_row<=end_row && start_col<=end_col){
            // top-line
            for(int j=start_col;j<=end_col;j++){
                System.out.print(arr[start_row][j]+" ");
            }


            // Right-Side
            for(int i=start_row+1;i<=end_row;i++){
                System.out.print(arr[i][end_col]+" ");
            }

            //bottom boundary
            for(int j=end_col-1;j>=start_col;j--){
                System.out.print(arr[end_row][j]+" ");
            }

            //left line.

            for(int i=end_row-1;i>=start_row+1;i--){
                System.out.print(arr[i][start_col]+" ");
            }
            start_row++;
            start_col++;
            end_col--;
            end_row--;
        }
    }
}