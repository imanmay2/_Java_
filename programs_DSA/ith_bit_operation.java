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
    public static void clear_range_ith_bit(int i,int j,int n){
        int a=(~0<<(j+1));
        int b=(1<<i)-1;
        System.out.println((a|b)&n);
    }


    public static boolean check_power_2(int n){
        return ((n&(n-1))==0);
    }


    public static int count_bit(int n){
        int ct=0;
        while(n!=0){
            int r=(n&1);
            if(r==1){
                ct++;
            }
            n=(n>>1);
        }
        return ct;
    }


    public static void main(String args[]){
        System.out.println(count_bit(10));
    }
}