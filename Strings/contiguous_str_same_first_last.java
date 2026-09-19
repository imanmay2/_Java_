// We are given a string S, we need to find the count of all contiguous substrings starting and ending with the same character


public class contiguous_str_same_first_last{
    public static void contiguous(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    // System.out.println(i+j);
                    System.out.print(str.substring(i,j+1)+" ");
                }
            }
        }
    }


    // solving with the help of recursion...
    public static void contiguous_recursion(String str,int i,int j){
        if(i==str.length()-1 && j==str.length()-1){
            return;
        }
        else if(str.charAt(i)==str.charAt(j)){
            System.out.print(str.substring(i,j+1));
        }
        

    }
    public static void main(String args[]){
        contiguous("abcab");
    }
}