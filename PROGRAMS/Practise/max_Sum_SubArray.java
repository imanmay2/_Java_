public class max_Sum_SubArray {
    //Calculate the sum of the prefix sum.
    public static void calcPrefixSum(int[] arr,int[] prefSum){
        int sum=arr[0];
        prefSum[0]=sum;
        for(int i=1;i<arr.length;i++){
            sum=sum+arr[i];
            prefSum[i]=sum;
        }
    }


    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        int[] arr={1,-2,6,-1,3};
        int[] prefSum=new int[arr.length];


        //calculate PrefixSum.
        calcPrefixSum(arr, prefSum);
        System.out.println("Prefix sum array is: ");
        print(prefSum);



    }
}
