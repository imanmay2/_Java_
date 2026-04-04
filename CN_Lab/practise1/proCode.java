//2D even pairty mechanism.

import java.util.Scanner;

public class proCode {

    public static String genBinary(char ch){
        int ascii=(int) ch;
        String bin=Integer.toBinaryString(ascii);
        while(bin.length()<7){
            bin='0'+bin;
        }
        return bin;
    }

    public static String[] rowParity(String arr[]){
         // for the row parity bit.
        for(int i=0;i<arr.length;i++){
            StringBuilder sb=new StringBuilder(arr[i]);
            int ct=0;
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='1'){
                    ct++;
                }
            } if(ct%2==0){
                sb.append('0');
            } else {
                sb.append('1');
            }
            arr[i]=sb.toString();
        }
        return arr;
    }


    public static String columnParity(String arr[]){
        String str_=new String("");
        //updated array will come over here.
        for(int j=0;j<8;j++){
            int ct=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i].charAt(j)=='1'){
                    ct++;
                }
            }
            if(ct%2==0){
                str_=str_+'0';
            }else{
                str_=str_+'1';
            }
        }
        return str_;
    }

    public static void printArr(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str=sc.next();

        int n=str.length();
        
        String arr[]=new String[n];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            arr[i]=genBinary(ch);
        }

        System.out.println(str+" Converted to Binary is: ");
        printArr(arr);
        System.out.println();
       //row parity
       System.out.println("Row Parity");
       rowParity(arr);
       printArr(arr);
       System.out.println();
       //column parity
       System.out.println("Column Parity");
       System.out.println(columnParity(arr));
    }
}
