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
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        subsetString(str, ans+str.charAt(i), i+1); //yes .
        subsetString(str, ans, i+1); //no .
    }

    public static void findPermutationStrings(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            findPermutationStrings(newStr, ans+curr);
        }
    }
    public static void main(String args[]){
        // int arr[]=new int[5];
        // backtrackArray(arr, 0);
        // System.out.println("Final Array : ");
        // printArr(arr);
        // subsetString("abc", "", 0);
        findPermutationStrings("abc", "");
    }
}