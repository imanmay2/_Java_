public class OOPS{
    public static void main(String args[]){
        Pen p1=new Pen();      //created p1 object.
        p1.setColor("Blue");  // function in class.
        System.out.println(p1.color);   //properties in class.
        p1.setTip(8);        
        System.out.println(p1.tip);



        //Creating bank account Class.
        Bank_Account myAcc=new Bank_Account();
        myAcc.username="imanmay2";
        System.out.println(myAcc.username);
        // System.out.println(myAcc.password);      // this has private access,  we can't acess it directly...

        myAcc.update_Password("!@#$");
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


class Bank_Account{
    public String username;
    private String password;
    public void update_Password(String passwd){
        passwd=passwd;
        System.out.println("Password updated");
    }
}