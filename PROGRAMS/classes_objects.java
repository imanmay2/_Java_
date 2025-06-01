import java.util.Scanner;

public class classes_objects {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name of the Student: ");
        String name=sc.nextLine();
        Greet g1=new Greet();
        g1.setName(name);
        System.out.print("Name you have entered is "+g1.getName());
    }
}


class Greet{
    String color;
    String name;
    Greet(){
        System.out.println("Hello , Java. welcome to Object oriented programming.");
    }

    void setName(String name){
        this.name=name;
    }

    String getName(){
        return this.name;
    }
}
