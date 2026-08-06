#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cout << "Enter number of stations: ";
    cin >> n;

    vector<int> entry(2), exitTime(2);

    cout << "Enter entry times:\n";
    cin >> entry[0] >> entry[1];

    cout << "Enter exit times:\n";
    cin >> exitTime[0] >> exitTime[1];

    vector<int> a1(n), a2(n);

    cout << "Enter processing times for Line 1:\n";
    for (int i = 0; i < n; i++)
        cin >> a1[i];

    cout << "Enter processing times for Line 2:\n";
    for (int i = 0; i < n; i++)
        cin >> a2[i];

    // Transfer times (n-1 values)
    vector<int> t1(n - 1), t2(n - 1);

    cout << "Enter transfer times from Line 1 to Line 2:\n";
    for (int i = 0; i < n - 1; i++)
        cin >> t1[i];

    cout << "Enter transfer times from Line 2 to Line 1:\n";
    for (int i = 0; i < n - 1; i++)
        cin >> t2[i];

    vector<int> f1(n), f2(n);

    // To reconstruct path
    vector<int> l1(n), l2(n);

    // Base case
    f1[0] = entry[0] + a1[0];
    f2[0] = entry[1] + a2[0];

    // DP
    for (int i = 1; i < n; i++) {

        // Compute Line 1
        if (f1[i - 1] + a1[i] <= f2[i - 1] + t2[i - 1] + a1[i]) {
            f1[i] = f1[i - 1] + a1[i];
            l1[i] = 1;
        } else {
            f1[i] = f2[i - 1] + t2[i - 1] + a1[i];
            l1[i] = 2;
        }

        // Compute Line 2
        if (f2[i - 1] + a2[i] <= f1[i - 1] + t1[i - 1] + a2[i]) {
            f2[i] = f2[i - 1] + a2[i];
            l2[i] = 2;
        } else {
            f2[i] = f1[i - 1] + t1[i - 1] + a2[i];
            l2[i] = 1;
        }
    }

    int finalLine;
    int ans;

    if (f1[n - 1] + exitTime[0] <= f2[n - 1] + exitTime[1]) {
        ans = f1[n - 1] + exitTime[0];
        finalLine = 1;
    } else {
        ans = f2[n - 1] + exitTime[1];
        finalLine = 2;
    }

    // Backtracking
    vector<int> path(n);
    path[n - 1] = finalLine;

    for (int i = n - 1; i > 0; i--) {
        if (path[i] == 1)
            path[i - 1] = l1[i];
        else
            path[i - 1] = l2[i];
    }

    // Output
    cout << "\nDP Table\n";
    cout << "Station\t";
    for (int i = 1; i <= n; i++)
        cout << i << "\t";
    cout << "\n";

    cout << "Line 1\t";
    for (int x : f1)
        cout << x << "\t";
    cout << "\n";

    cout << "Line 2\t";
    for (int x : f2)
        cout << x << "\t";
    cout << "\n";

    cout << "\nMinimum Manufacturing Time = " << ans << "\n";

    cout << "\nOptimal Path\n";
    for (int i = 0; i < n; i++) {
        cout << "Station " << i + 1 << " -> Line " << path[i] << endl;
    }
    return 0;
}