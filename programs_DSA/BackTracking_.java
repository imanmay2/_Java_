public class BackTracking_ {

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }System.out.println();
    }
    public static void backtrackArray(int arr[],int i){
        //base case
        if(i==arr.length){
            System.out.println("Array first time");
            printArr(arr);
            return;
        }
        arr[i]=i+1;
        backtrackArray(arr, i+1);
        arr[i]=arr[i]-2;
    }

    public static void subsetString(String str,String ans,int i){
        //base case
        if(str.length()==i){

            if(ans.length()==0){
                System.out.println("null");
                return;
            }
            System.out.println(ans);
            return;
        }
        subsetString(str, ans+str.charAt(i), i+1);//yes , string is onn
        subsetString(str, ans, i+1); //no, string is not taking part. 
    }
    public static void main(String args[]){
        // int arr[]=new int[5];
        // backtrackArray(arr, 0);
        // System.out.println("Final Array : ");
        // printArr(arr);

        subsetString("abc", "", 0);
    }
}
