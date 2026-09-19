import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class KCC {

    public static ArrayList<Integer> getList(int num){
        String str_=Integer.toString(num);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<str_.length();i++){
            list.add(Integer.parseInt(str_.charAt(i)+""));
        }
        return list;
    }


    public static int getNum(ArrayList list){
        String s="";
        for(int i=0;i<list.size();i++){
            s=s+list.get(i);
        }
        return Integer.parseInt(s);
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
        int ct=0;
        while(true){
            ArrayList<Integer> list_asc=getList(n);
            Collections.sort(list_asc);
            ArrayList<Integer> list_desc=getList(n);
            Collections.sort(list_desc,Collections.reverseOrder());
            int num1=getNum(list_desc);
            int num2=getNum(list_asc);
            if(num1-num2==6174){
                System.out.println("Match Found ! ");
                System.out.println("Count of KCC finding pairs is :"+ct);
                break;
            }
            else{
                n=num1-num2;
                ct++;
            }
        }
    }
}
