import java.util.Scanner;

public class Assignment_Q_Recursion{

    public static void print(String str,int i,String arr[]){
        if(i==str.length()){
            return;
        }

        System.out.print(arr[(str.charAt(i)-'0')]+" ");
        print(str, i+1, arr);

    }
    public static void main(String args[]){
        String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        String str=Integer.toString(n);
        System.out.println(str);
        print(str, 0, arr);
    }
}
