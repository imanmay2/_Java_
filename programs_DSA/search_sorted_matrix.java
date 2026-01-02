public class Search_Sorted_Matrix {
    public static void Search_Sorted_Matrix(int arr[][],int key){
        int row=0;
        int col=arr[0].length-1;
        boolean f=false;
        while(row<arr.length && col>=0){
            if(key>arr[row][col]){
                row++;
            } else if(key<arr[row][col]){
                col--;
            } else{
                f=true;
                System.out.println("Element found at index: "+row+","+col);
                break;
            }
        }
        if(f==false){
            System.out.println("So sorry,Element not found in the matrix.");
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

        Search_Sorted_Matrix(arr, 23);
    }
}
