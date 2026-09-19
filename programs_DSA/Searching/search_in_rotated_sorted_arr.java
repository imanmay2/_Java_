// Write a program , that will  search the target in the rotated sorted array.


public class search_in_rotated_sorted_arr{
    public static int search(int arr[],int si,int target,int ei){
        int mid=(si+ei)/2;
        // basecase 
        if(si>ei){
            return -1;
        }
        else if(arr[mid]==target){
            return mid;
        }
        else if(arr[si]<=arr[mid]){
            if(arr[si]<=target && target<=arr[mid]){
                return search(arr,si,target,mid);
            }
            else{
                return search(arr,mid+1,target,ei);
            }

        }
        else if(arr[mid]<=arr[ei]){
            if(target<=arr[ei] && target>=arr[mid]){
                return search(arr,mid,target,ei);
            }
            else{
                return search(arr,si,target,mid-1);
            }
        }
        return 0;
    }
    public static void main(String args[]){
        int target=2;
        int arr[]={4,5,6,7,0,1,2};
        System.out.println(search(arr,0,target,arr.length-1));
    }
}