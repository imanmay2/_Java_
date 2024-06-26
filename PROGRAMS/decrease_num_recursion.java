// Print the numbers from num to 1.


public class decrease_num_recursion{
    public static void decrease(int n){
        if(n==1){
            System.out.println(n);
        }
        else{
            System.out.println(n);
            decrease(n-1);
        }
    }


    public static void main(String args[]){
        int n=10;
        decrease(n);
    }
}

