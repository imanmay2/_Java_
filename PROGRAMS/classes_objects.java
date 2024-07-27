import java.util.*;
public class classes_objects{
    public static void main(String args[]){
        Pen p1=new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color);

        bankAcc b1=new bankAcc();    // constructor.
        b1.setPass("hello@1234");   // settters.
        System.out.println(b1.getPass());   // getters.

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

    private String getPass(){
        return this.password;           // passwords can't be accessed.
    }
}