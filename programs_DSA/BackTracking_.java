public class BackTracking_ {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void backtrackArray(int arr[], int i) {
        // base case
        if (i == arr.length) {
            System.out.println("Array first time");
            printArr(arr);
            return;
        }
        arr[i] = i + 1;
        backtrackArray(arr, i + 1);
        arr[i] = arr[i] - 2;
    }

    public static void subsetString(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        subsetString(str, ans + str.charAt(i), i + 1); // yes .
        subsetString(str, ans, i + 1); // no .
    }

    public static void findPermutationStrings(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutationStrings(newStr, ans + curr);
        }
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][],int row,int col){
        //vertical up check
        for(int i=board.length-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //left diagonal check
        for(int i=row-1 ,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal check 
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }

    public static void N_Queens(char board[][], int row){
        if (row == board.length) {
            System.out.println("-------Chess Board--------");
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                N_Queens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }
    public static void main(String args[]) {
        // int arr[]=new int[5];
        // backtrackArray(arr, 0);
        // System.out.println("Final Array : ");
        // printArr(arr);
        // subsetString("abc", "", 0);
        // findPermutationStrings("abc", "");
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        N_Queens(board, 0);
    }
}