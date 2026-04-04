import java.util.ArrayList;
import java.util.Scanner;

public class matrix_AL {
    public static void printArr(ArrayList<ArrayList<Integer>> arr1){
        for(int i=0;i<arr1.size();i++){
            for(int j=0;j<arr1.get(i).size();j++){
                System.out.print(arr1.get(i).get(j)+" ");
            }
            System.out.println();

        }
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
        
        Scanner sc=new Scanner(System.in);

        int row=2;
        int col=3;
        for(int i=0;i<row;i++){
            ArrayList<Integer> arr2=new ArrayList<>();
            for(int j=0;j<col;j++){
                arr2.add(sc.nextInt());
            }
            arr1.add(arr2);
        }

        ///print the 2D ArrayList.
        printArr(arr1);
    }
}
