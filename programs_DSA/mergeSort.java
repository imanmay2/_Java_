
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

        //for the remaining elements.
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
        for(i=si,k=0;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void mergeSort_(int arr[],int si,int ei){
        if(si>=ei){
            //base case
            return;
        }

        int mid=si+((ei-si)/2);

        //mergeSort for the left array.
        mergeSort_(arr, si, mid);

        ///mergeSort for the right array
        mergeSort_(arr,mid+1, ei);

        //merging  the right and left most array.
        merge(arr, si, mid, ei);
    } 

    public static void  printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    


    public  static void main(String args[]){
        int arr[]={6,3,9,5,2,8,-2};
        mergeSort_(arr,0, arr.length-1);
        printArr(arr);
    }
}
