import java.util.*;
public class input_of_array_and_print_array{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the range of inputing the number from the user");
        int n=sc.nextInt();
        int[] marks=new int[n];
        for(int i=0;i<=n-1;i++){
            System.out.println("Enter the number to be added in the array of marks");
            int num=sc.nextInt();
            marks[i]=num;
        }
        System.out.println("Array is as follows");
        for(int j=0;j<=marks.length-1;j++){
            System.out.print(marks[j]+" ");
        }
    }
}