
public class mergeSort {

    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid  && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];

                i++;
            } else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }


        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }


        while(j<=ei){
            temp[k]=arr[j];
            k++;
            j++;
        }


        //copying the temp array to the original array.
        for(i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
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
        merge(arr, si, mid, ei);

    } 
    


    public  static void main(String args[]){
        int arr[]={6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
    }
}
