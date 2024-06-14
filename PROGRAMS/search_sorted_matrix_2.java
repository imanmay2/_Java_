import java.util.*;
public class search_sorted_matrix_2{
    public static boolean search(int[][] matrix,int key){
        int row=matrix.length-1;
        int col=0;
        while(row>=0 && col<matrix.length){
            if(key==matrix[row][col]){
                System.out.print("Element found at position : ("+row+","+col+")");
                return true;
            }
            else if(key>matrix[row][col]){
                col++;
            }
            else if(key<matrix[row][col]){
                row--;
            }
        }
        System.out.print("Element not found !!");
        return false;
    }


    public static void main(String args[]){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int key=7;
        search(matrix,key);
    }
}