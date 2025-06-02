import java.util.ArrayList;
import java.util.Scanner;

public class two_Dimensional_AL{

    public static void print2D_Arr(ArrayList<ArrayList<Integer>> arr){
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        int row=3;
        int col=4;
        
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Enter the element: ");
                arr2.add(sc.nextInt());
            }
            arr1.add(arr2);
        }

        print2D_Arr(arr1);
    }
}