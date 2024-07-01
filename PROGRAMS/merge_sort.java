// Write a function , that will sort the gievn array..using merge sort algorithm...

public class merge_sort{
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void merge_sort(int arr[],int si,int ei){
        //base case
        if(si>=ei){
            return;
        }
        int mid=(si+ei)/2;
        merge_sort(arr,si,mid);
        merge_sort(arr,mid,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){
        int temp_arr[]=new int[ei-si+1];
        int k=0;
        int i=si;
        int j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp_arr[k]=arr[i];
                i++;
            }
            else{
                temp_arr[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp_arr[k++]=arr[i++];
        }

        while(j<=ei){
            temp_arr[k++]=arr[j++];
        }

        //copy the temp_arr to the original array.
        for(k=0,i=0;k<temp_arr.length;i++,k++){
            arr[i]=temp_arr[k];
        }
    }


    public static void main(String args[]){
        int arr[]={6,3,2,8,5,9};
        merge_sort(arr,0,arr.length);
        print(arr);
    }
}