#include <iostream>

using namespace std;


class Solution {
public:
    int romanToInt(string s) {
        int ans = 0, i = 0;

        while (i < s.length()) {
            char letter = s[i];

            if (letter == 'I') {
                char nextLetter = s[i + 1];
                if (nextLetter == 'V') {
                    ans += 4;
                    i += 1;
                }
                else if (nextLetter == 'X') {
                    ans += 9;
                    i += 1;
                }
                else {
                    ans += 1;
                }
            }

            if (letter == 'V') {
                ans += 5;
            }

            if (letter == 'X') {
                char nextLetter = s[i + 1];
                if (nextLetter == 'L') {
                    ans += 40;
                    i += 1;
                }
                else if (nextLetter == 'C') {
                    ans += 90;
                    i += 1;
                }
                else {
                    ans += 10;
                }
            }

            if (letter == 'L') {
                ans += 50;
            }

            if (letter == 'C') {
                char nextLetter = s[i + 1];
                if (nextLetter == 'D') {
                    ans += 400;
                    i += 1;
                }
                else if (nextLetter == 'M') {
                    ans += 900;
                    i += 1;
                }
                else {
                    ans += 100;
                }
            }

            if (letter == 'D') {
                ans += 500;
            }

            if (letter == 'M') {
                ans += 1000;
            }

            i += 1;
        }

        return ans;
    }
};


int main() {
    Solution s;
    string str;
    cin >> str;
    cout << s.romanToInt(str);
    return 0;
}