// Friends pair problem...


public class friends_pairing_problem{
    public static int pair_ways(int n){
        if(n==1 || n==2){
            return n;
        }
        //for single friend.
        int f1=pair_ways(n-1);


        // for pairing friends.
        int f2=(n-1)*pair_ways(n-2);

        return f1+f2;
    } 

    public static void main(String args[]){
        System.out.print(pair_ways(3));
    }
}