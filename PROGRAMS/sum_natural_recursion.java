// WAP that will print the sum of the first n natural numbers using recursion.



public class sum_natural_recursion{
    public static int sum(int num){
        int s=0;
        if(num==0){
            return 0;
        }
        s=num+sum(num-1);
        return s;
    }
    
    public static void main(String args[]){
        System.out.print(sum(5));
    }
}