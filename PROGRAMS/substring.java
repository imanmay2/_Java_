// Write a function that will print the substring of the given string.



import java.util.*;
public class substring{
    public static void substring(String str,int start,int end){
        for(int i=start;i<end+1;i++){
            System.out.print(str.charAt(i));
        }
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String  : ");
        String str=sc.nextLine();
        System.out.print("Enter the Starting index and the ending index respectively : ");
        int start=sc.nextInt();
        int end=sc.nextInt();
        substring(str,start,end);
    }
}