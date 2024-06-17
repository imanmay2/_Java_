class Solution {
    public static  long reverse_int(int x){
        long num=0;
        while(x!=0){
            int r=x%10;
            num=(num*10)+r;
            x=x/10;
        }
        return num;
    }
    public int reverse(int x) {
        long rev = 0;
        if(x>=0){
            rev=reverse_int(x);
        }
        else if(x<0){
            rev=-1*(reverse_int(-1*x));
        }
        int constr = (int)Math.pow(2,31);
        if (rev > constr || rev < (-1*constr)) {
            return 0;
        }
        return (int)rev;
    }
}