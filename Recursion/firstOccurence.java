

public class firstOccurence {
    public static int firstOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(key==arr[i]){
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }
    public static void main(String args[]){
        int arr[]={8,3,6,9,5,10,2,5,3};
        System.out.println("Key found at index: "+firstOccurence(arr,5,0));
    }   
}
