// Accept the price of 3 items, a pencil,pen and an erasor.....add 18% of gst and display the total amount.


import java.util.*;
public class gst_tax{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the price for the pencil : ");
        float pencil=sc.nextFloat();
        System.out.println("Enter the price for the pen : ");
        float pen=sc.nextFloat();   
        System.out.println("Enter the price for the erasor : ");
        float erasor=sc.nextFloat();
        float total=(pencil+pen+erasor+ (0.18*pencil)+(0.18*pen)+(0.18*erasor));
        System.out.println("Total cost of the products are : "+total);
    }
}