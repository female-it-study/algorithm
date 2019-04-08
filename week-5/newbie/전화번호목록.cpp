#include <string>
#include <vector>

using namespace std;

bool solution(vector<string> numbers) {
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = 0; j < numbers.size(); j++) {
            if (i == j)
                continue;
            if (numbers[i].length() > numbers[j].length())
                continue;
            bool notPrefix = false;
            for (int k = 0; k < numbers[i].length(); k++) {
                if (numbers[i][k] != numbers[j][k]) {
                    notPrefix = true;
                    break;
                }
            }
            if (notPrefix == false)
                return false;
        }
    }
    return true;
}
