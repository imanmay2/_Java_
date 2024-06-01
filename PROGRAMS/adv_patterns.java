// Creating a single file for all types of pattern.


public class adv_patterns{
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


    public static void zero_one_triangle(){
        for(int i=0;i<=4;i++){
            for(int j=0;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else if((i+j)!=0){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void hollow_rectangle(){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i==1 || i==5 || j==1 || j==5){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void inverted_rotated_half_pyramid(){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if((i+j)>=6){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void butterfly(int n){
        //Printing the patterrn for the first half....
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        

        //printing the 2nd half of the pattern.
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void diamond(int n){

        //printing for 1st half
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }


        //printing for 2nd half
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void X_pattern(){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if((i==j) || (i+j)==6){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        X_pattern();
    }
}