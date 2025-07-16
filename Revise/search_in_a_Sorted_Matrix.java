public class search_in_a_Sorted_Matrix {
    public static void searchMatrix(int arr[][],int key){
        int row=0;
        int col=arr[0].length-1;
        while(row<arr[0].length && col>=0){
            if(key==arr[row][col]){
                System.out.println("Element found at "+row + ","+col);
                return;
            } else if(key>arr[row][col]){
                row++;
            } else{
                col--;
            }
        }
        System.out.println("No matching element found in the Matrix.");
    }


    public static void searchMatrix2(int arr[][],int key){
        int row=arr.length-1;
        int col=0;

        while(row>=0 && col<arr[0].length){
            if(key==arr[row][col]){
                System.out.println("Element found at "+row + ","+col);
                return;
            } else if(key<arr[row][col]){
                row--;
            } else{
                col++;
            }
        }
        System.out.println("No such matching element found !! ");
    }
    public static void main(String args[]){
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        searchMatrix(arr, 6);
        System.out.println();
        searchMatrix2(arr, 6);
    }
}