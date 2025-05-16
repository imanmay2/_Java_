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

    public static void main(String args[]){
        Xpattern(5);
    }
}
