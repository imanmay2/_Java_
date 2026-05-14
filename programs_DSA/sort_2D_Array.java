public class sort_2D_Array {


    public static void printArr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[][]={{4,7},{3,2},{1,4}};
        System.out.println("Original array is : ");
        printArr(arr);

        //sorting based on 0th index
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i][0]>arr[j][0]){
                    int arr_[]=arr[i];
                    arr[i]=arr[j];
                    arr[j]=arr_;
                }
            }
        }

        System.out.println("Sorted Array is ");
        printArr(arr);

    }
}
