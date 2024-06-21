public class OOPS{
    public static void main(String args[]){
        Pen p1=new Pen();      //created p1 object.
        p1.setColor("Blue");  // function in class.
        System.out.println(p1.color);   //properties in class.
        p1.setTip(8);        
        System.out.println(p1.tip);



        //Creating bank account Class.
        Bank_Account myAcc=new Bank_Account();
        myAcc.setUsername("imanmay2");
        System.out.println(myAcc.get_username());
        // System.out.println(myAcc.password);      // this has private access,  we can't acess it directly...

        myAcc.setPasswd("!@#$");
        System.out.println(myAcc.get_passwd());




        Student s1=new Student("Anwesha");
        System.out.println("Name is: "+ s1.name);
    }
}


class Student{
    String name;
    Student(String name){
        System.out.println("Constrcutor is being deifned....");
        this.name=name;
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
    private String username;
    private String password;
    // public void update_Password(String passwd){
    //     passwd=passwd;
    //     System.out.println("Password updated");
    // }


    String get_username(){
        return this.username;
    }
    String get_passwd(){
        return this.password;
    }

    void setUsername(String username){
        this.username=username;
        System.out.println("Username Updated");
    }

    void setPasswd(String password){
        this.password=password;
        System.out.println("Password Updated");
    }
}