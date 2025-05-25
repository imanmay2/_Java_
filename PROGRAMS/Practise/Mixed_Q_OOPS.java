// Problem Statement:

// You are required to simulate a real-world scenario using Java inheritance. Create a program with the following specifications:

// Create a class Vehicle that contains:
// A static variable vehicleCount to keep track of the number of vehicles created.
// A constructor that increments vehicleCount.
// A method displayInfo() that prints:
// "Vehicle Created. Total Vehicles: X" (where X is the current value of vehicleCount)

// Create a subclass Car that:
// Has an instance variable brand.
// A constructor that takes the brand name as an argument.
// In the constructor, use the super keyword to call the parent class constructor.
// Overrides the displayInfo() method to print:
// "Car Brand: [brand]"
// Then, use super.displayInfo() to print the base class message.

// In the main method:
// Create three Car objects with different brand names.
// Call the displayInfo() method for each object.




public class Mixed_Q_OOPS {
    public static void main(String args[]){
        Car c1=new Car("Honda");
        c1.displayInfo();


        Car c2=new Car("Hero");
        c2.displayInfo();

        
        Car c3=new Car("Maruti");
        c3.displayInfo();

    }
}


class Vehicle{
    static int vehicleCount=0;

    Vehicle(){
        vehicleCount++;
        // System.out.println("Parent Constructor called.");
    }

    public void displayInfo(){
        System.out.println("Vehicle created. Count of vehicles: "+vehicleCount);
    } 
}

class Car extends Vehicle{
    String carName;
    
    Car(String carName){
        super();
        this.carName=carName;
        // System.out.println("Child Class constructor called.");
    }

    public void displayInfo(){
        System.out.println("Car Brand: "+carName);
        super.displayInfo();
    }

}