public class Spiral_Matrix {


    public static void Spiral_Matrix(int arr[][]){
        int startRow=0;
        int endRow=arr.length-1;

        int startCol=0;
        int endCol=arr[0].length-1;
 
        while(startRow<=endRow && startCol<=endCol){

            //top border;
            for(int j=startCol;j<=endCol;j++){
                System.out.print(arr[startRow][j]+" ");
            }

            //right border.
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr[i][endCol]+" ");
            }

            //bottom border.
            for(int j=endCol-1;j>=startCol;j--){
                System.out.print(arr[endRow][j]+" ");
            }

            //left border.
            for(int i=endRow-1;i>startRow;i--){
                System.out.print(arr[i][startCol]+" ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }
    public static void main(String args[]){
        int arr[][]={
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        Spiral_Matrix(arr);
    }
}
