// import java.util.*;

// // class Employee{
// //     String name;
// //     int id;
// //     double basicSalary;
// //     Employee(String name,int id,double basicSalary){
// //         this.name=name;
// //         this.id=id;
// //         this.basicSalary=basicSalary;
// //     }

// //     public void display(){
// //         System.out.println("Name is : "+name + " Id is : "+id);
// //     }


// //     public double calcSalary(){
// //         return basicSalary;
// //     }


// // }


// // class Manager extends Employee{
// //     String dept;
// //     double bonus;
// //     public Manager(String name,int id,double basicSalary,String dept,double bonus){
// //         super(name,id,basicSalary);
// //         this.dept=dept;
// //         this.bonus=bonus;

// //     }

// //     public double calcSalary(){
// //         return basicSalary+bonus;
// //     }

// //     public void display(){
// //         System.out.println("Name: "+name+" id: "+id+" Salary is now : "+calcSalary());
// //         System.out.println("Dept : "+dept);
// //     }
// // }


// abstract class Animal{
//     void walk(){
//         System.out.println("Animal walks");
//     }
//     abstract void talk();
// }

// class Human extends Animal{


//     //override
    
//     void walk(){
//         System.out.println("Human walks");
//     }
//     void talk(){
//         System.out.println("Human talks");
//     }
// }

// public class Inheritance {
//     public static void main(String args[]){
//         // Manager m1=new Manager("Anwesha", 1234, 10000, "ECE", 2000);
//         // m1.display();

    
//         Animal h1;
//         h1=new Human();
//         h1.walk();
//         h1.talk();
//     }
// }

import java.io.*;

public class Inheritance{

    public static void readFile() throws IOException{
        FileReader fr=new FileReader("hello.txt");

    }

    public static void validate(int age){
        if(age<18){
            throw new ArithmeticException("Not Allowed");
        }else{
            System.out.println("Access Granted....");
        }
    }
    public static void main(String args[]){
        try{
            readFile();
        } catch(IOException e){
            System.out.println("Handled Exception");
        }
    }
}