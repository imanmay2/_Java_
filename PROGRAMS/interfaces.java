// Problem Statement:

// Create a Java program that simulates multiple inheritance using interfaces.
// You are to define two interfaces:

// Flyable – with a method void fly();
// Swimmable – with a method void swim();

// Then create a class Duck that implements both interfaces and overrides their methods to print:
// "Duck is flying" for fly().
// "Duck is swimming" for swim().
// In the main method, create an object of the Duck class and call both methods.






public class Interfaces {
    public static void main(String args[]){
        Duck d1=new Duck();
        d1.fly();
        d1.swim();


        Bird b1=new Bird();
        b1.fly();
        b1.swim();
    }
}



interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

class Duck{
    void fly(){
        System.out.println("Duck is flying");
    }
    void swim(){
        System.out.println("Duck is swimming.");
    }
}

class Bird{
    void fly(){
        System.out.println("Birds are flying.");
    }

    void swim(){
        System.out.println("Birds can't swim.");
    }
}