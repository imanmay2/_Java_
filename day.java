import java.util.Scanner;
public class day {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the days between 1 to 7");
        int d=sc.nextInt();
        switch(d){
            case 1:
            System.out.print("Sunday");
            break;
            case 2:
            System.out.print("Monday");
            break;
            case 3:
            System.out.print("Tuesday");
            break;
            case 4:
            System.out.print("Sunday");
            break;
            case 5:
            System.out.print("Sunday");
            break;
            case 6:
            System.out.print("Sunday");
            break;
            case 7:
            System.out.print("Sunday");
            break;
            default:
            System.out.print("Please enter number from 1 to 7");
        }
    }
}
