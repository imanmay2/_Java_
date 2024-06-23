public class interfaces{
    public static void main(String args[]){
        Queen q=new Queen();
        q.moves();
        King k=new King();
        k.moves();
    }
}
interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("Queen Wins");
    }
}


class King implements ChessPlayer{
    public void moves(){
        System.out.println("King wins");
    }
}