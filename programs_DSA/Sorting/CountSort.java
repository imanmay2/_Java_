public class CountSort {

    public static int max(int arr[]){
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]={1,4,1,3,2,4,3,7};
        int freq[]=new int[max(arr)+1];

        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        System.out.println("Sorted Array is: ");
        for(int i=0;i<freq.length;i++){
            int curr=freq[i];
            while(curr>0){
                System.out.print(i+" ");
                curr--;
            }
        }


    }
}
