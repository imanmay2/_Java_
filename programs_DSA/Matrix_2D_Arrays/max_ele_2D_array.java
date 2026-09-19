// WAP that will input the 2D array. and print the maximum and minimum element from the 2D array.



import java.util.*;
public class max_ele_2D_array{
    public static void maxi_mini(int[][] arr){
        int mini=Integer.MAX_VALUE;
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(mini>arr[i][j]){
                    mini=arr[i][j];
                }
                if(maxi<arr[i][j]){
                    maxi=arr[i][j];
                }
            }
        }
        System.out.println(maxi+","+mini);
    }



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[3][4];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println("Enter the element in the 2D array : ");
                arr[i][j]=sc.nextInt();
            }
        }


        System.out.println("The Maximum and minimum from the 2D-array is : ");
        maxi_mini(arr);

        
    }
}
    