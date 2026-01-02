//There is an integer array nums that consists of n unique elements,but you have forgetten it.However,you 
// do remember every pair of adjacent elements in nums.

// You are given a 2D integer array and adjacentPairs of size n-1 where each and adjacent pairs[i]=[ui,vi]
// which indicates that the elements ui and vi are two adjacent terms in nums.

// It is guaranteed that every adjacent pairs of elements nums[i] and nums[i+1] will exist in adjacent pairs,
//either as [num[i],nums[i+1]] or nums[i+1],nums[i]].

import java.util.Scanner;

public class hackathon_2D_Array_Q {

    //creating a function whether a number is already present in the array.
    public static boolean check(int num,int[] arr){
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n-1][2];

        //pushing the element in the array created.
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println("Enter the number : ");
                arr[i][j]=sc.nextInt();
            }
        }

        //creating a new array.
        int[] arr_=new int[n];
        int k=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!check(arr[i][j],arr_)){
                    k++;
                    arr_[k]=arr[i][j];
                }
            }
        }
        System.out.println();

        System.out.println("Output is as follows: ");

        System.out.println();


        //printing the newly created array.
        for(int i=0;i<arr_.length;i++){
            System.out.print(arr_[i]+" ");
        }

    }
}
