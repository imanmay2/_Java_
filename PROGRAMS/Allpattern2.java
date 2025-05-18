public class Allpattern2 {

    public static void rightTrianglePattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if((i+j)>=(n+1)){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            } System.out.println();
        }
    }


    public static void hollowRightTrianglePattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if((i+j)==(n+1) || i==n || j==n){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            } System.out.println();
        }
    }


    public static void zeroOnePattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else if((i+j)%2!=0){
                    System.out.print("0");
                }
            }System.out.println();
        }
    }

    public static void Xpattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j || (i+j)==n+1){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            } System.out.println();
        }
    }

    public static void flyodTriangle(int n){
        int k=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int n){

        // for the upper part.
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int k=1;k<=2*(n-i);k++){
                System.out.print(" ");
            }

            for(int m=1;m<=i;m++){
                System.out.print("*");
            }

            System.out.println();
        }


        //for the lower part.
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int k=1;k<=2*(n-i);k++){
                System.out.print(" ");
            }

            for(int m=1;m<=i;m++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String args[]){
        butterflyPattern(4);
    }
}
