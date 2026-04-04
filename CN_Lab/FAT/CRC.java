import java.util.Arrays;

public class CRC{
    public static String mod2div(String dividend,String divisor){
        char temp[]=dividend.toCharArray();
        int n=divisor.length();
        for(int i=0;i<=temp.length-n;i++){
            if(temp[i]=='1'){
                for(int j=0;j<n;j++){
                    temp[i+j]=(temp[i+j]==divisor.charAt(j))?'0':'1';
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=temp.length-n+1;i<temp.length;i++){
            sb.append(temp[i]);
        }
        return sb.toString();
    }




    public static void main(String args[]){
        String str1="11010110110000";
        String str2="10011";
        System.out.println(mod2div(str1, str2));

    }
}