public class binarySearch_{

    public static int binarySearch(int arr[],int target,int si,int ei){
        ///base case
        if(si>ei){
            return -1;
        }


        int mid=si+(ei-si)/2;

        if(arr[mid]==target){
            return mid;
        }
        else if(arr[si]<=arr[mid]){
            //Line L1
            if(arr[si]<=target && target<=arr[mid]){
                return binarySearch(arr, target, si, mid-1);
            } else{
                return binarySearch(arr, target, mid+1, ei);
            }
        } else if(arr[mid]<=arr[ei]){
            //Line L2
            if(arr[mid]<=target && target<=arr[ei]){
                return binarySearch(arr, target, mid+1, ei);
            } else{
                return  binarySearch(arr, target, si, mid-1);
            }
        }
        return mid;
    }

    public static int binarySearchReursion(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }

        int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }


        else if(arr[mid]>target){
            return binarySearchReursion(arr, target, si, mid-1);
        } else{
            return binarySearchReursion(arr, target, mid+1, ei);
        }
    }
    public static void main(String args[]){
        int arr[]={0,1,2,4,5,6,7};
        System.out.println(binarySearchReursion(arr, 6, 0, arr.length-1));
    }
}