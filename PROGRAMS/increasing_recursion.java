public class increasing_recursion{
    public static void increase(int num){
        if(num==1){
            System.out.print(num+" ");
            return;
        }

        increase(num-1);
        System.out.print(num+" ");
    }

    public static void main(String args[]){
        increase(5);
    }
}