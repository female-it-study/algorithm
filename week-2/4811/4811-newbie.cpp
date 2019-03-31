#include <iostream>
using namespace std;

long long cache[30][30];

long long eat(int w, int h) {
    if (w == 0 && h == 0) return 1;
    if (cache[w][h] != 0) return cache[w][h];
    
    if (w != 0) cache[w][h] += eat(w - 1, h + 1);
    if (h != 0) cache[w][h] += eat(w, h - 1);
    return cache[w][h];
}

int main() {
    int input;
    cin >> input;
    while (input != 0) {
        cout << eat(input, 0) << endl;
        cin >> input;
    }
    return 0;
}