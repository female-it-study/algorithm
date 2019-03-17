#include <iostream>
#include <vector>
#include <utility>
using namespace std;

int getMinDiff(vector<pair<int, int> > &foods) {
    int minDiff = abs(foods[0].first - foods[0].second);
    for (int i = 1; i < foods.size(); i++)
        minDiff = min(minDiff, abs(foods[i].first - foods[i].second));
    return minDiff;
}

void cook(vector<pair<int, int> > &foods, vector<int> &results, int index, long long sour, long long bitter) {
    if (index == foods.size()) { 
        if (sour == 1 && bitter == 0)
            results.push_back(getMinDiff(foods));
        else
            results.push_back(abs(sour - bitter));
        return;
    }
    
    int s = foods[index].first;
    int b = foods[index].second;
    cook(foods, results, index + 1, sour * s, bitter + b);
    cook(foods, results, index + 1, sour, bitter);
}

int main() {
    int n;
    cin >> n;
    
    vector<pair<int, int> > foods;
    for (int i = 0; i < n; i++) {
        int sour, bitter;
        cin >> sour >> bitter;
        foods.push_back(make_pair(sour, bitter));
    }

    vector<int> results;
    cook(foods, results, 0, 1, 0);

    int minDiff = results[0];
    for (int i = 1; i < results.size(); i++) {
        minDiff = min(minDiff, results[i]);
    }
    cout << minDiff << endl;
    return 0;
}