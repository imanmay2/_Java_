// top left triangle pattern



public class top_left_tri_pattern{
    public static void main(String args[]){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if((i+j)<=(5+1)){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}