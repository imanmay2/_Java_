public class buy_andSellStock{
    public static int calcMin(int[] arr,int k){
        int mini=0;
        for(int i=0;i<k;i++){
            if(i==0){
                mini=arr[i];
            }
            else{
                mini=Math.min(mini,arr[i]);
            }
        }
        return mini;
    }
    public static void main(String args[]){
        int[] arr={7,1,5,3,6,4};

        
        int max=0;

        for(int i=1;i<arr.length;i++){
            int profit=arr[i]-calcMin(arr,i);
            profit=profit<0?0:profit;     //ternary operator.

            if(profit>max){
                max=profit;
            }
        }

        System.out.print("Maximum profit gained is: "+max);
    }
}