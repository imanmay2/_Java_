// Write a program , that will  search the target in the rotated sorted array.


public class search_in_roated_sorted_arr{
    public static int search(int arr[],int si,int target,int ei){
        int mid=(si+ei)/2;
        if(arr[si]<arr[mid]){
            if(target>arr[si] && target<arr[mid]){
                return search(arr,si,target,mid-1);
            }
            else{
                
            }
        }
    }
    public static void main(String args){
        target=0;
        int arr[]={4,5,6,7,0,1,2};
        System.out.println(search(arr,0,target,ei));
    }
}