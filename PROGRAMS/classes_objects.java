import java.util.*;
public class classes_objects{
    public static void main(String args[]){
        Pen p1=new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color);

        bankAcc b1=new bankAcc();    // constructor.
        b1.setPass("hello@1234");   // settters.
        System.out.println(b1.getPass());   // getters.


        Student s1=new Student();
        


        // copying the data from s1 object to a new object...
        Student s2=new Student(s1);         // shallow copy...
        

        System.out.println(s2.name);
        System.out.println(s2.roll);
        System.out.println(s2.password);

    }
}


class Pen{
    String color;
    int tip;
    void setColor(String newColor){
        color=newColor;
    }
}


class bankAcc{
    public String username;
    private String password;
    public void setPass(String password){
        this.password=password;
    }
    public String getPass(){
        return this.password;           // passwords can't be accessed.
    }
}


class Student {
    String name="Anwesha";
    int roll=1;
    String password="hello@1234";
    // Student(String name){       //constructor
    //     this.name=name;
    // }
}
class Student{
    Student(Student s1){
        this.name=s1.name;
        this.password=s1.password;
        this.roll=s1.roll;
    }
}