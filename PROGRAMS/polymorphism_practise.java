import java.util.*;
public class polymorphism_practise{
    public static void main(String args[]){
        Dear d1=new Dear();
        d1.eat();       //function overwriting will take place.
    }
}



// class Calculator {
//     int sum(int a,int b){
//         return a+b;
//     }

//     float sum(float a,float b){
//         return a+b;
//     }
// }

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
