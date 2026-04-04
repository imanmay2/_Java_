// Write a recursive function to find and dispaly the index's of the key present in the array.

public class all_occurences_idx{
    public static int key_idx(int arr[],int key,int i){
        if(i==arr.length){
            return 0;
        }
        else if(key==arr[i]){
            System.out.print(i+" ");
        }
        return key_idx(arr,key,i+1);
    }
    public static void main(String args[]){
        int[] arr={3, 2, 4, 5, 6, 2, 7, 2, 2};
        key_idx(arr,2,0);
    }
}