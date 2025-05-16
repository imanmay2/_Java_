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
        
    }
    public static void main(String args[]){
        rightTrianglePattern(6);
    }
}
