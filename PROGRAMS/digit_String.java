// You are given a number (eg -  2019), convert it into a String of english like“two zero one nine”. 
//  Use a recursive function to solve this problem.


public class digit_String{
    public static String dig_str(int num,String arr[],int i,StringBuilder sb){
        String str=Integer.toString(num);
        
        int idx=(int)(str.charAt(i)-'0');
        //base case
        if(i==str.length()-1){
            sb.append(arr[idx]);
            sb.append(" ");
            return sb.toString();
        }
        sb.append(arr[idx]);
        sb.append(" ");
        return dig_str(num,arr,i+1,sb);
    }
    public static void main(String args[]){
        String[] arr={"zero","one","two","three","four","five","six","seven","eight","nine"};
        int num=4567;
        StringBuilder sb=new StringBuilder("");
        System.out.print(dig_str(num,arr,0,sb));
    }
}