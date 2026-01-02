// Write a program in java, that will count the length of the string using recursion and without using .length() function.


public class count_length_recursion{
    public static int count(String str,int i,int ct){
        //base case...
        if(i==str.length()){
            return ct;
        }
        ct++;
        return count(str,i+1,ct);
    }
    public static void main(String args[]){
        System.out.print(count("Anwesha",0,0));
    }
}