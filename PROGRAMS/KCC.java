import java.util.Collections;
import java.util.Scanner;

public class KCC {

    public static ArrayList<Integer> getList(int num){
        String str_=String(num);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<str_.length;i++){
            list.add(int(str_[i]));
        }
        return list;
    }


    public static int getNum(ArrayList<Integer> list){
        String s_="";
        for(int i=0;i<list.size();i++){
            s=s+list.get(i);
        }
        return int(s);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
        boolean f=false;
        int ct=0;
        while(f==false){
            ArrayList<Integer> list_asc=Collections.sort(getList(n));
            ArrayList<Integer> list_desc=Collections.sort(getList(n),Collections.reverseOrder());
            int num1=getNum(list_desc);
            int num2=getNum(list_asc);
            if(num1-num2==6174){
                System.out.println("Match Found ! ");
                System.out.println("Count of KCC finding pairs is :"+ct);
                f=true;
                break;
            }
            else{
                num=num1-num2;
            }
        }
    }
}
