// Write a program that will display the subset of the string....


public class subsetString{
    public static void backtrack(String str,int i,String ans){
        //basecase
        if(str.length()==i){
            if(ans.length()==0){
                System.out.println("NULL");
            }
            else{
            System.out.println(ans);}
            return;
        }

        backtrack(str,i+1,ans+str.charAt(i));    //YES wala condition
        backtrack(str,i+1,ans);                  //NO wala condition....
    }
    public static void main(String args[]){
        backtrack("abc",0,"");
    }
}