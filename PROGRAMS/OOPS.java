public class OOPS{
    public static void main(String args[]){
        Pen p1=new Pen();      //created p1 object.
        p1.setColor("Blue");  // function in class.
        System.out.println(p1.color);   //properties in class.
        p1.setTip(8);        
        System.out.println(p1.tip);
    }
}


class Pen{
    String color;
    int tip;
    void setColor(String newColor){
        color=newColor;
    }

    void setTip(int tip_){
        tip=tip_;
    }
}