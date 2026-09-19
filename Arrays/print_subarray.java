// Print the subarrays of the given array.


public class print_subarray{
    public static void main(String args[]){
        int[] arr={1,2,3,4,5,6};
        System.out.println("The subarrays are : ");
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                System.out.print(+arr[j]);
                if(j!=(arr.length-1)){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}