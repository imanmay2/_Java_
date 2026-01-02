import java.util.Scanner;
public class String_Compression {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        System.out.print("Enter the string: ");
        String str=sc.nextLine();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int count=1;

            while(i+1<str.length() && ch==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                sb.append(ch+Integer.toString(count));
                continue;
            }

            sb.append(ch);

        }

        System.out.println("String is: "+sb.toString());
    }
}
