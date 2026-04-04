import java.util.Scanner;

public class shortestPath{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();

        int x=0;
        int y=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                x++;
            } else if(str.charAt(i)=='S'){
                x--;
            } else if(str.charAt(i)=='E'){
                y++;
            } else if(str.charAt(i)=='W'){
                y--;
            }
        }

        System.out.println("The coordinates are: "+"("+x+","+y+")");
        System.out.println("Shortest distance is: "+Math.sqrt((x*x)+(y*y)));
    }
}