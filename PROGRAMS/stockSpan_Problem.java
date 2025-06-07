import java.util.Stack;

public class stockSpan_Problem {

    public static void calcSpan(int arr[], int span[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
                System.out.print(" + + " + span[i]);
            }
            s.push(i);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[arr.length];
        calcSpan(arr, span);
        print(arr);
        print(span);
    }
}
