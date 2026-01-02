// Count the number of times each number occurs in the array & find the largest count.


public class count_largest_frequency{
    public static int count(int arr[]){
        int num=0;
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=i;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>maxi){
                maxi=count;
                num=arr[i];
            }
            
        }
        return num;
    }


    public static void main(String args[]){
        int arr[]={1,1,2,2,3,3,3,3,3,3,3,3,3,3,3,4,4};
        System.out.print("The most repeated number in the array is : "+  count(arr));
    }
}