import java.util.*;
public class search_sorted_matrix{
    public static boolean search(int[][] matrix,int key){
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(key==matrix[row][col]){
                System.out.print("Element found at position : ("+row+","+col+")");
                return true;
            }
            else if(key>matrix[row][col]){
                row++;
            }
            else if(key<matrix[row][col]){
                col--;
            }
        }
        System.out.print("Element not found !!!!");
        return false;
    }


    public static void main(String args[]){
        int[][] matrix={
            {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        int key=7;
        search(matrix,key);
    }
}