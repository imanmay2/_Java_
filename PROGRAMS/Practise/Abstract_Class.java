public class Abstract_Class {
    public static void main(String args[]){
        Dog d1=new Dog();
        d1.walk();
        d1.breathe();
    }
}


abstract class Animal{
    void walk(){
        System.out.println("Animal walks");
    }
    abstract void breathe();
}


class Dog extends Animal{
    void breathe(){
        System.out.print("Animal breathes");
    }
}