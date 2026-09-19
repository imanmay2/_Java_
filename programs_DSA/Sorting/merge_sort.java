// Write a program that  will  sort an array..using merge sort....

public class merge_sort{
    public static void print_arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void merge_sort(int arr[],int si,int ei){
        //base case
        if(si==ei){
            return;
        }
        int mid=(si+ei)/2;
        merge_sort(arr,si,mid);
        merge_sort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){
        int temp_Arr[]=new int[ei-si+1];
        int k=0;
        int i=si;
        int j=mid+1;
        while(i<mid && j<ei){
            if(arr[i]<arr[j]){
                temp_Arr[k]=arr[i];
                i++;
            }
            else{
                temp_Arr[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            temp_Arr[k++]=arr[i++];
        }
        while(j<ei){
            temp_Arr[k++]=arr[j++];
        }

        for(i=si,k=0;k<temp_Arr.length;k++,i++){
            arr[i]=temp_Arr[k];
        }

    }
    public static void main(String args[]){
        int arr[]={6,1,8,2,3,5};
        merge_sort(arr,0,arr.length);
        print_arr(arr);
    }
}