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

        System.out.println("Inheritance Restarted !!!!");
        System.out.println();

        Dogs d1=new Dogs();
        d1.breathe();
        d1.reproduce();
        d1.legs();




    }
}


class Animal{               //Parent Class.
    void breathe(){
        System.out.println("Animal breathes");
    }

    void eat(){
        System.out.println("Animal eats");
        
    }
}


class Fish extends Animal{      // Child Class---->Implementing Inheritance.
    void swim(){
        System.out.println("Fish swims");
    }
}


class Mammals extends Animal{
    void reproduce(){
        System.out.println("Reproduce Sexually");
    }
}


class Dogs extends Mammals{
    void legs(){
        System.out.println("Dog are  4 legged Mammals");
    }
}