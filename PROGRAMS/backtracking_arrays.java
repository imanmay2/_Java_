// Write a program that will bactrack the array...


public class backtracking_arrays{
    public static void backtrack(int arr[],int i){
        //base case
        if(arr.length==i){
            print_Arr(arr);
            System.out.println();
            return;
        }
        arr[i]=i+1;
        backtrack(arr,i+1);
        arr[i]=arr[i]-2;
    }
    public static void print_Arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        int arr[]=new int[5];
        backtrack(arr,0);
        print_Arr(arr);
    }
}