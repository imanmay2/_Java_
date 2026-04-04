import java.util.Scanner;
public class CRCCode {


    public static String mod2div(String dividend,String divisor){
        int n=divisor.length();
        char temp[]=dividend.toCharArray();
        
        for(int i=0;i<=temp.length-n;i++){
            if(temp[i]=='1'){
                for(int j=0;j<n;j++){
                    temp[i+j]=(temp[i+j]==divisor.charAt(j)?'0':'1');
                }
            }
        }

        //Remainder is the last n-1 bit's
        StringBuilder sb=new StringBuilder();
        for(int i=temp.length-n+1;i<temp.length;i++){
            sb.append(temp[i]);
        }

        return sb.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data : (10101011)");
        String data=sc.next();
        System.out.println("Enter the polynomial binary: (10101)");
        String divisor=sc.next();
        String dividend=data;
        for(int i=1;i<=divisor.length()-1;i++){
            dividend=dividend+'0';
        }

        System.out.println("CodeWord : "+dividend);
        System.out.println("Divisor : "+divisor);

        //Node A sends to Node B

        System.out.println("Data from Node A to Node B : ");
        String reminder=mod2div(dividend, divisor);
        String codeword=data+reminder;

        String r1=mod2div(codeword, divisor);
        System.out.println(r1);
        boolean flag=false;
        System.out.println("Reminder : "+reminder);
        for(int i=0;i<divisor.length()-1;i++){
            if(r1.charAt(i)=='1'){    
                flag=true;
            }
        }
        if(flag==false){
            System.out.println("No error found in Node B.");
        } else{
            System.out.println("Error found in Node B");
        }


        //LAst bit of the codeword is flipped in C.
        char ch=codeword.charAt(codeword.length()-1);
        StringBuilder sb_=new StringBuilder(codeword);
        if(ch=='1'){
            sb_.setCharAt(codeword.length()-1, '0');
        } else{
            sb_.setCharAt(codeword.length()-1, '1');
        }

        //Operation in Node C.
        String reminder_=mod2div(sb_.toString(), divisor);
        System.out.println("Reminder : "+reminder_);

         boolean flag_=false;
        for(int i=0;i<divisor.length()-1;i++){
            if(reminder_.charAt(i)=='1'){
                flag_=true;
            }
        }
        if(flag_==false){
            System.out.println("No error found in Node C.");
        } else{
            System.out.println("Error found in Node C.");
        }
    }
}
