public class diagonal_Sum_2D {
    public static void main(String args[]){
        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13,14,15,16}
        };

        int priSum=0;
        int secSum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    priSum+=arr[i][j];
                } else if(i+j==arr.length-1){
                    secSum+=arr[i][j];
                }
            }
        }

        System.out.println("Primary Sum is: "+priSum);
        System.err.println("Secondary Sum is: "+secSum);
    }
}
