// Write a recursive function that will find the first occurence of the element in the array.


public class first_occurence{
    public static boolean check(int arr[],int key,int i){
        if(arr[i]==key){
            return true;
        }
        else if(arr[i]!=key && i==arr.length-1){
            return false;
        }
        return check(arr,key,i+1);
    }

    public static void main(String args[]){
        int[] arr={1,2,3,4};
        int key=5;
        System.out.print(check(arr,key,0));
    }
}