// practisisng inheritance


public class inheritance{
    public static void main(String args[]){
        Fish f1=new Fish();
        f1.eat();
        f1.breathe();
        f1.fins(24);
    }
}



class Animal{
    void eat(){
        System.out.println("Eats");
    }

    void breathe(){
        System.out.println("Breathes");
    }
}


class Fish extends Animal{
    int fins;
    void fins(int fins){
        this.fins=fins;
        System.out.println(this.fins);
    }
}