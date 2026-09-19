import java.util.*;
public class guess_number{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int guessNum=(int)(Math.random()*100);
        System.out.println("Enter your guessing number");
        int num=sc.nextInt();
        while(true){
            if(num==guessNum){
                System.out.print("Yeah!!!!!Match Found!!!!Right Guesser");
                break;
            }
            else if(num<guessNum){
                System.out.println("Number is Smaller");
            }
            else if(num>guessNum){
                System.out.println("Number is Larger");
            }
            System.out.println("Please enter a number to continue or enter -1 to break");
            num=sc.nextInt();
            if(num<0){
                System.out.println("You have come out of from the game!!!!!!!!!!!!!!!!!!");
                System.out.print("Number to be guessed is "+guessNum);
                break;
            }
        }
    }
}