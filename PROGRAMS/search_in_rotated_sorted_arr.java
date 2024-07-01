// Write a program , that will  search the target in the rotated sorted array.


public class search_in_rotated_sorted_arr{
    public static int search(int arr[],int si,int target,int ei){
        int mid=(si+ei)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(target>arr[mid]){
            return search(arr,mid+1,target,ei);
        }
        else if(target<arr[mid]){
            return search(arr,si,target,mid-1);
        }
        else if(si>ei){
            System.out.println(si+" "+ ei);
            return -1;
        }
        return 0;
    }
    public static void main(String args[]){
        int target=4;
        int arr[]={4,5,6,7,0,1,2};
        System.out.println(search(arr,0,target,arr.length-1));
    }
}