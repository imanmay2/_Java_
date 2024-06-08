// Given an array. Sort it via BUBBLE SORT METHod.



public class SORTING{
    public static void bubble_sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<(arr.length-i)-1;j++){
                if(arr[j]>arr[j+1]){
                     int temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                }
            }
        }
    }


    public static void main(String args[]){
        int[] arr={8,1,7,2,6,3,5};
        bubble_sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}