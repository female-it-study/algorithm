#include <iostream>
#include <cmath>
using namespace std;

int searchZ(int n, int r, int c, int startR, int startC, long long count) {
    if (n == 0) return count;
    
    if (r < startR + pow(2, n-1) && c < startC + pow(2, n-1)) {
        return searchZ(n - 1, r, c, startR, startC, count);
    } else if (r < startR + pow(2, n-1) && c >= startC + pow(2, n-1)) {
        return searchZ(n - 1, r, c, startR, startC + pow(2, n-1), count + pow(pow(2, n-1), 2));
    } else if (r >= startR + pow(2, n-1) && c < startC + pow(2, n-1)) {
        return searchZ(n - 1, r, c, startR + pow(2, n-1), startC, count + 2 * pow(pow(2, n-1), 2));
    } else {
        return searchZ(n - 1, r, c, startR + pow(2, n-1), startC + pow(2, n-1), count + 3 * pow(pow(2, n-1), 2));
    }
}

int main() {
    int N, r, c;
    cin >> N >> r >> c;
    cout << searchZ(N, r, c, 0, 0, 0) << endl;
    return 0;
}