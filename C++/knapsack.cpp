#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

int main() {
    int n, W;

    cout << "Enter the number of items: ";
    cin >> n;

    cout << "Enter the knapsack capacity: ";
    cin >> W;

    vector<int> wt(n + 1), profit(n + 1);

    cout << "Enter the weights:\n";
    for (int i = 1; i <= n; i++)
        cin >> wt[i];

    cout << "Enter the profits:\n";
    for (int i = 1; i <= n; i++)
        cin >> profit[i];

    // DP Table
    vector<vector<int>> dp(n + 1, vector<int>(W + 1, 0));

    // Build DP Table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= W; j++) {

            if (wt[i] <= j)
                dp[i][j] = max(dp[i - 1][j],
                               profit[i] + dp[i - 1][j - wt[i]]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }

    // Print DP Table
    cout << "\nDynamic Programming Table\n\n";

    cout << setw(8) << "Item";
    for (int j = 0; j <= W; j++)
        cout << setw(3) << j;
    cout << endl;

    cout << "------------------------------------\n";

    for (int i = 0; i <= n; i++) {
        cout << setw(4) << i << " ";
        for (int j = 0; j <= W; j++)
            cout << setw(3) << dp[i][j];
        cout << endl;
    }

    cout << "\nMaximum Profit = " << dp[n][W] << endl;

    // Traceback
    vector<int> selected;
    int totalWeight = 0;
    int totalProfit = 0;

    int i = n, j = W;

    while (i > 0 && j > 0) {

        if (dp[i][j] != dp[i - 1][j]) {
            selected.push_back(i);
            totalWeight += wt[i];
            totalProfit += profit[i];
            j -= wt[i];
        }

        i--;
    }

    cout << "\nSelected Items:\n";

    for (int k = 0; k < selected.size(); k++) {
        int idx = selected[k];
        cout << "Item " << idx
             << " (Weight = " << wt[idx]
             << ", Profit = " << profit[idx] << ")\n";
    }

    cout << "\nTotal Weight = " << totalWeight << endl;
    cout << "Total Profit = " << totalProfit << endl;

    return 0;
}
