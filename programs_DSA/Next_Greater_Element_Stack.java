import java.util.Stack;

public class Next_Greater_Element_Stack {

    public static void  nextGreaterElement(int arr[],int great[]){
        Stack<Integer> s=new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]>=s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                great[i]=-1;
            } else{
                great[i]=s.peek();
            }
            s.push(arr[i]);
        }
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[]={6,8,0,1,3};
        int great[]=new int[arr.length];
        nextGreaterElement(arr, great);
        print(arr);
        print(great);
    }
}
