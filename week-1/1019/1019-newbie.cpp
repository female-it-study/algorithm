/* 
    baekjoon 1019
    Q. 지민이는 N쪽인 책이 한권 있다. 첫 페이지는 1쪽이고, 마지막 페이지는 N쪽이다. 
       각 숫자가 모두 몇 번이 나오는지 출력하는 프로그램을 작성하시오. 
*/

#include <vector>
#include <iostream>
using namespace std;

void count(vector<long long> &numCounts, int n, int digit) {
    if (n / digit == 0) return;

    int front = n / (digit * 10);
    int current = (n % (digit * 10)) / digit;
    int back = n % digit;
    for (int i = 0; i < 10; i++) {
        if (i < current)
            numCounts[i] += (front + 1) * digit;    
        else
            numCounts[i] += front * digit;
    }
    numCounts[current] += back + 1;
    numCounts[0] -= digit;
    
    count (numCounts, n, digit * 10);
}

int main() {
    int N;
    cin >> N;

    vector<long long> numCounts(10);
    count(numCounts, N, 1);

    for (int i = 0; i < 10; i++)
        cout << numCounts[i] << " ";
    cout << endl;
    return 0;
}