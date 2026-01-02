// Input the side of the square and diaply it's area.

import java.util.*;
public class square_area{
    public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the side of the square : ");
    float s=sc.nextFloat();
    float ar=s*s;
    System.out.println("Area of the square is : "+ar);
}}