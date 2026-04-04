import java.util.*;
public class polymorphism_practise{
    public static void main(String args[]){
        Dear d1=new Dear();
        d1.eat();       //function overriding will take place.

        Calculator c=new Calculator();
        System.out.println(c.sum(1,2));
        System.out.print(c.sum(1,2,3));
    }
}



class Calculator {
    int sum(int a,int b){
        return a+b;
    }

    int sum(int a,int b,int c){
        return (a+b+c);
    }
}

class Animal{
    void eat(){
        System.out.println("Animal Eats");
    }
}

class Dear extends Animal{
    void eat(){
        System.out.println("Dear Eats!!!!");
    }
}
