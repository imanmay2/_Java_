import java.util.*;
public class inheritance_practise{
    public static void main(String args[]){
        Animal a1=new Animal();
        a1.breathe();
        a1.eat();


        Fish f1=new Fish();
        f1.swim();
        f1.breathe();
        f1.eat();
    }
}


class Animal{
    void breathe(){
        System.out.println("Animal breathes");
    }

    void eat(){
        System.out.println("Animal eats");
        
    }
}


class Fish extends Animal{      // Implementing Inheritance.
    void swim(){
        System.out.println("Fish swims");
    }
}