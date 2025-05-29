public class Last_Occurence {

    public static int lastOccurence(int arr[],int key,int i,int idx){
        if(i==arr.length){
            return idx;
        }
        if(key==arr[i]){
            idx=i;
        }

        return lastOccurence(arr, key, i+1, idx);
    }
    public static void main(String args[]){
        int arr[]={8,3,6,9,5,10,2,5,5};
        System.out.println(lastOccurence(arr, 5, 0, -1));
    }
}
