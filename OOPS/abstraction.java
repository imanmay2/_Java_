public class abstraction{
    public static void main(String args[]){
        Horse h1=new Horse();
        h1.walk();
        Chicken c1=new Chicken();
        c1.walk();
    }
}


abstract class Animal{
    void eat(){
        System.out.println("Animal eats!!");
    }
    abstract void walk();
}



class Horse extends Animal{
    void walk(){
        System.out.println("Horse walks");
    }
}


class Chicken extends Animal{
    void walk(){
        System.out.println("Chicken walks");
    }
}