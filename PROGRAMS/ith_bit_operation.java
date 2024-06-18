// get,set,clear ith bith operations...



public class ith_bit_operation{
    public static  void get_bit(int i,int n){
        System.out.println("The ith bit is : "+ ((1<<i)&n));
    }

    public static void set_bit(int i,int n){
        System.out.println("The updated bit is "+ ((1<<i)|n));
    }

    public static void clear_bit(int i,int n){
        System.out.println("The updated bit is : "+ (~(1<<i)&n));
    }
    public static void update_ith_bit(int i,int n,int u){
        if(u==0){
            clear_bit(i,n);
        }
        else if(u==1){
            set_bit(i,n);
        }
    }
    public static void clear_last_ith_bit(int n,int i){
        System.out.println(((-1)<<i)&n);
    }


    public static void main(String args[]){
        clear_last_ith_bit(15,2);
    }
}