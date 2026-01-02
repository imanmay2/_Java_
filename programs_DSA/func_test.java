// testing whether i can call a function from another function...

public class func_test{
    public static void print1(){
        System.out.println("Running first function . ");
    }
    public static void print2(){
        print1();
    }
    public static void main(String args[]){
        print2();
    }
}