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




        Student s1=new Student();
        s1.name="Anwesha";
        s1.roll=1;
        s1.passwd="hello";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s2=new Student(s1);         //copy of the constructor..
        s2.passwd="xyz";
        s1.marks[1]=100;
        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
    }
}


class Student{
    String name;
    int roll;
    String passwd;
    int[] marks=new int[3];
    Student(){
        System.out.println("Constrcutor is being deifned....");
        this.name=name;
    }



    // This is a shallow copy.....
    // Student(Student s1){
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.passwd=s1.passwd;
    //     this.marks=s1.marks;
    // }

    //deep copy...
    Student(Student s1){
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
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