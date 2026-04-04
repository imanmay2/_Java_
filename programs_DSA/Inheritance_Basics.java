public class Inheritance_Basics {
    public static void main(String args[]){
        Dog d1=new Dog();
        d1.eat();
        d1.breathe();
        d1.walk();
        System.out.println(d1.name);
    }
}


class Animal{
    protected String name="Hello Java";
    public void eat(){
        System.out.println("Animal eats");
    }
}


class Mammal extends Animal{
    public void breathe(){
        System.out.println("Mammal breathes");
    }
}


class Dog extends Mammal{
    public void walk(){
        System.out.println("Dog Walks");
    }
}


