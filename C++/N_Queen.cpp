#include <iostream>
#include <vector>
using namespace std;

bool isSafe(vector<vector<char>> &board, int row, int col, int n) {

    // Check upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q')
            return false;
    }

    // Check same column
    for (int i = row - 1; i >= 0; i--) {
        if (board[i][col] == 'Q')
            return false;
    }

    // Check upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
        if (board[i][j] == 'Q')
            return false;
    }

    return true;
}

bool solve(vector<vector<char>> &board, int row, int n) {

    if (row == n)
        return true;

    for (int col = 0; col < n; col++) {

        if (isSafe(board, row, col, n)) {

            board[row][col] = 'Q';

            if (solve(board, row + 1, n))
                return true;

            // Backtrack
            board[row][col] = '.';
        }
    }

    return false;
}

int main() {

    int n;

    cout << "Enter the number of queens: ";
    cin >> n;

    vector<vector<char>> board(n, vector<char>(n, '.'));

    if (solve(board, 0, n)) {

        cout << "\nOne Valid Solution\n\n";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                cout << board[i][j] << " ";
            cout << endl;
        }

        cout << "\nQueen Positions\n";

        int queen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    cout << "Queen " << queen
                         << ": Row " << i + 1
                         << ", Column " << j + 1 << endl;
                    queen++;
                }
            }
        }

    } else {

        cout << "No solution exists" << endl;

    }

    return 0;
}