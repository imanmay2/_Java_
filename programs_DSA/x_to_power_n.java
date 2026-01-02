public class x_to_power_n {
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }


    public static int optimizePower(int x,int n){
        int res;
        if(n==1 || n==0){
            return x*n;
        }
        if(n%2==0){
            res=optimizePower(x, n/2);
            return res*res;
        } else{
            res=optimizePower(x, n/2);
            return x*res*res;
        }
    }
    public static void main(String args[]){
        System.out.println("Power is: "+optimizePower(2,5));
    }
}