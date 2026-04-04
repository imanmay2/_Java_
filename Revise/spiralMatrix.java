public class spiralMatrix {
    public static void spiralMatrix(int arr[][],int n){
        int startRow=0,endRow=n-1,startCol=0,endCol=n-1;

        while(startRow<=endRow && startCol<=endCol){

            //top column printed.
            for(int i=startCol;i<=endCol;i++){
                System.out.print(arr[startRow][i]+" ");
            }

            //right row now.
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr[i][endCol]+" ");
            }

            //bottom row
            for(int i=endCol-1;i>=startCol;i--){
                System.out.print(arr[endRow][i]+" ");
            }

            //left row.
            for(int i=endRow-1;i>=startRow+1;i--){
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
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        spiralMatrix(arr, arr.length);
    }
}
