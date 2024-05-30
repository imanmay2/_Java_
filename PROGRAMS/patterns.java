// Creating a single file for all types of pattern.


public class patterns{
    public static void inverted_half_pyra(){
        for(int i=5;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(){
        int k=0;
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                k++;
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }




    public static void main(String args[]){
        inverted_half_pyra();

        floyds_triangle();
    }
}