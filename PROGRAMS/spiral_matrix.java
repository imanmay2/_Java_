// WAP THAT WILL PRINT THE MATRIX IN THE SPIRAL ORDER.


import java.util.*;
public class spiral_matrix{
    public static void main(String args[]){
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}};

            int start_row=0;
            int end_row=arr.length-1;
            int start_col=0;
            int end_col=arr[1].length-1;
            while(start_row<=end_row && start_col<=end_col){
                // printing the upper above boundary.

                for(int j=start_row;j<=end_col;j++){
                    System.out.print(arr[start_row][j]+" ");
                }
                if(start_row==end_col || end_row==start_col){
                    break;
                }


                // printing the right border boundary.
                for(int i=start_row+1;i<=end_row;i++){
                    System.out.print(arr[i][end_col]+" ");
                }


                //printing the bottom border boundary.
                for(int j=end_col-1;j>=start_col;j--){
                    System.out.print(arr[end_row][j]+" ");
                }

                //printing the left most border boundary.
                for(int i=end_row-1;i>=start_row+1;i--){
                    System.out.print(arr[i][start_col]+" ");
                }


                start_row++;
                start_col++;
                end_row--;
                end_col--;
            }
    }
}