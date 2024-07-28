import java.util.*;
public class interfaces_practise{
    public static void main(String args[]){
        Animal a1=new Animal();
        System.out.println(a1.breathes());
    }
}



interface func{
    void breathes();
    void eats();
    void sleeps();
    
}


class Animal implements func{
    public void breathes(){
        System.out.println("Animal breathes");
    }

    public void eats(){
        System.out.println("Animal eats");
    }

    public void sleeps(){
        System.out.println("Animal Sleeps");
    }
}


// class Mammals extends Animal{
//     void reproduce(){
//         System.out.println("Reproduce Sexually");
//     }
// }

// class Dogs extends Mammals{
//     void legs(){
//         System.out.println("Dogs have 4 legs");
//     }
// }