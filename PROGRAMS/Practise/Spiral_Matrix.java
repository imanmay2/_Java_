public class Spiral_Matrix {


    public static void Spiral_Matrix(int arr[][]){
        startRow=0;
        endRow=arr.length-1;

        startCol=0;
        endCol=arr[0].length-1;

        while(startRow<=endRow && startCol<=endCol){

            //top border;
            for(int j=startCol;j<=endCol;j++){
                System.out.print(arr[j]+" ");
            }

            //right border.
            for(int i=startRow+1;i<endRow;i++){
                System.out.print(arr[i]+" ");
            }

            //bottom border.
            for(int j=endCol-1;>=startCol;j--){
                System.out.print(arr[j]+" ");
            }

            //left border.
            for(int i=endRow-1;i>startRow;i--){
                System.out.print(arr[i]+" ");
            }

        }
    }
    public static void main(String args[]){
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        }


        
    }
}
