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

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up check
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean N_Queens(char board[][], int row) {
        if (row == board.length) {
            System.out.println("-------Chess Board--------");
            printBoard(board);
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (N_Queens(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'x';
            }
        }
        return false;
    }

    public static int grid_ways(int i, int j, int n, int m) {
        // base case
        if (i > n || j > m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        return grid_ways(i + 1, j, n, m) + grid_ways(i, j + 1, n, m);
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isSafeSudoku(int sudoku[][], int digit, int row, int col) {
        // checking for the row
        for (int i = 0; i <9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // checking for col;
        for (int j = 0; j <9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // checking if the digit is present in the grid or not.
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if(nextCol+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // else portion
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafeSudoku(sudoku, digit, row, col)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col]=0; //step for the backtracking
            }
        }
        return false;
    }

    public static void main(String args[]) {
        // int arr[]=new int[5];
        // backtrackArray(arr, 0);
        // System.out.println("Final Array : ");
        // printArr(arr);
        // subsetString("abc", "", 0);
        // findPermutationStrings("abc", "");
        // int n = 2;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = 'x';
        // }
        // }
        // if(N_Queens(board, 0)){
        // System.out.print("Solution Exists.");
        // }else{
        // System.out.println("Solution doesn't exists.");
        // }

        // int n=3,m=3;
        // System.out.println(grid_ways(0, 0, n, m));

        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution Exists");
            printSudoku(sudoku);
        }else{
            System.out.println("Solution doesn't exists");
        }
        
    }
}