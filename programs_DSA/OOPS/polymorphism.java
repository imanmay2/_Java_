// Practising polymorphism...



public class polymorphism{
    public static void main(String args[]){
        Calculator calc=new Calculator();
        System.out.println(calc.sum(4,4));
        System.out.println(calc.sum((float)2.5,(float)1.5));

        Dear d1=new Dear();
        d1.eat();

    }
}


// overloading polymorphism....or complile time polymorphism
class Calculator{
    int sum(int a,int b){
        return a+b;
    }

    float sum(float a,float b){
        return a+b;
    }
}


// overridding polymorphism....or runtime polymorphism...
class Animal{
    void eat(){
        System.out.println("Eats evrything....");
    }
}

class Dear extends Animal{
    void eat(){
        System.out.println("Eats grass....");
    }
}