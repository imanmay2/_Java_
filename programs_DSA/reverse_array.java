// Reverse an array.


public class reverse_array{
    public static void main(String args[]){
        int[] arr={1,2,3,4,5};
        int s=0;
        int l=(arr.length-1);
        while(s<l){
            int temp=arr[l];
            arr[l]=arr[s];
            arr[s]=temp;
            s++;
            l--;
        }
        System.out.println("Updated Arr is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}