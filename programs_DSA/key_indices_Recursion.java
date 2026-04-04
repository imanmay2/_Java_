public class key_indices_Recursion {
    public static void findKey(int arr[],int key,int i){
        if(i==arr.length){
            return;
        }

        if(arr[i]==key){
            System.out.println(i+" ");
        }

        findKey(arr, key, i+1);
    }
    public static void main(String args[]){
        int arr[]={3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key=2;
        findKey(arr,key, 0);
    }
}
