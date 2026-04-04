public class sum_of_natural_number {

    public static int sum_Natural_Number(int num){
        int s=0;
        if(num==0){
            return 0;
        }
        s=num+sum_Natural_Number(num-1);
        return s;
    }
    public static void main(String args[]){
        int num=5;
        System.out.print("Sum of the natural number is: "+sum_Natural_Number(num));
    }
}
