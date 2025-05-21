public class max_Sum_SubArray{
    public static void main(String args[]){
        int[] arr={-2,-3,4,-1,-2,1,5,-3};

        int[] currSum=new int[arr.length];

        int sum=0;
        int max=0;


        sum=sum+arr[0];
        if(sum<0){
            currSum[0]=0;
        } else{
            currSum[0]=sum;
            if(sum>max){
                max=sum;
            }
        }
        for(int i=1;i<arr.length;i++){
            sum=currSum[i-1]+arr[i];
            if(sum<0){
                currSum[i]=0;
            } else{
                currSum[i]=sum;
                if(sum>max){
                    max=sum;
                }
            }
        }


        System.out.println("Maximum Subarray sum is: "+max);
    }
}