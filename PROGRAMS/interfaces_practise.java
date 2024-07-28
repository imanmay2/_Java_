import java.util.*;
public class interfaces_practise{
    public static void main(String args[]){
        Queen q1=new Queen();
        System.out.println(q1.moves());
    }
}


interface chessPlayer{
    void moves();
}


class Queen implements chessPlayer{
    public void moves(){
        System.out.println("King!!!!");
    }
}