import java.util.Stack;

public class max_Area_Histogram_Stack {

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void maxHistArea(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int sl[] = new int[arr.length];
        int sr[] = new int[arr.length];

        // calculating the right side smallest element.
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                sr[i] = s.peek();
            } else {
                sr[i] = sr.length;
            }
            s.push(i);
        }

        // calculating the left side smallest element.
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                sl[i] = s.peek();
            } else {
                sl[i] = -1;
            }
            s.push(i);
        }

        System.out.println("Left small side array : ");
        print(sl);
        System.out.println("Right small side array : ");
        print(sr);
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            maxArea=Math.max(maxArea, arr[i]*(sr[i]-sl[i]-1));
        }

        System.out.println("The maxiumum area in the histogram is: "+maxArea);

    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxHistArea(arr);
    }
}