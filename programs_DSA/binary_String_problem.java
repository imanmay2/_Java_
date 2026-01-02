public class binary_String_problem {

    public static void binaryString(int n,int lastPosition,String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        binaryString(n-1, 0, str+'0');
        if(lastPosition==0){
            binaryString(n-1, 1, str+'1');
        }
    }
    public static void main(String args[]){
        binaryString(3,0,"");
    }
}
