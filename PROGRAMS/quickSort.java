public class quickSort {

    public static int pivotIdx(int arr[],int si,int ei){
        int i=si-1;

        for(int j=si;j<ei;j++){
            if(arr[j]<arr[ei]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        i++;
        //swapping the pivot value with the ith idx.
        int temp=arr[ei];
        
        
    }
    public static void quickSort_(int arr[],int si,int ei){
        
        ///base case
        if(si>=ei){
            return;
        }



    }
    public static void main(String[] args) {
        int arr[]={6,3,9,8,2,5};

    }
}
