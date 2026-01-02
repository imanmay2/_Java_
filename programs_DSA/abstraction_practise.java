import java.util.*;
public class abstraction_practise{
    public static void main(String args[]){
        Horse h1=new Horse();
        h1.eat();
        System.out.println();
        h1.walk();
    }
}


abstract class Animal{
    void eat(){
        System.out.println("Animal Walks");
    }

    // abstract void walk();
}


class Horse extends Animal{
    void walk(){
        System.out.println("Horse Walks");
    }
}