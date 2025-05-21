import java.util.Scanner;
public class Array_2D {

    public static void print_2D(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the row: ");
        int row=sc.nextInt();
        System.out.print("Enter the column: ");
        int col=sc.nextInt();
        int arr[][]=new int[row][col];
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print("Enter the number: ");
                arr[i][j]=sc.nextInt();
            }
        }

        print_2D(arr);
    }
}
