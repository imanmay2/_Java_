//Write a program that will implement binary search using recursion.

public class binary_search_recursion{
    public static int binary_Search(int arr[],int si,int ei,int target){
        int mid=(si+ei)/2;
        //basecase
        if(si>ei){
            return -1;
        }
        else if(arr[mid]==target){
            return mid;
        }
        else if(target<arr[mid]){
            return binary_Search(arr,si,mid-1,target);
        }
        else if(arr[mid]<target){
            return binary_Search(arr,mid+1,ei,target);
        }
        return 0;
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        System.out.println("The element found at index : "+ binary_Search(arr,0,arr.length-1,1));
    }
}