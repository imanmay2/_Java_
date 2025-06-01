package Practise;



public class mergeSort {

    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        

    }
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){

            //base case
            return;
        }

        int mid=si+(ei-si)/2;

        //mergeSort for the left array.
        mergeSort(arr, si, mid);

        ///mergeSort for the right array
        mergeSort(arr,mid+1, ei);

        //merging  the right and left most array.


    } 


    public  static void main(String args[]){
        int arr[]={6,3,9,5,2,8};
    }
}
