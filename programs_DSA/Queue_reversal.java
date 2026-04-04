import java.util.*;;
public class Queue_reversal{
    public static void main(String args[]){
        Queue<Integer> q1=new ArrayDeque<>();
        for(int k=1;k<=5;k++){
            q1.add(k);
        }
        int[] arr=new int[q1.size()];
        int j=0;
        while(!q1.isEmpty()){
            arr[j]=q1.remove();
            j++;
        }


        //Adding from the array back to the Queue in the reverse order.
        for(int i=arr.length-1;i>=0;i--){
            q1.add(arr[i]);
        }


        //printing the queue.
        while(!q1.isEmpty()){
            System.out.println(q1.remove());
        }
    }
}
