#include <iostream>
#include <map>

using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int strSize = s.size();
        int maxLen = 0, len = 0;
        map<char, int> freq;

        for (int i = 0; i < strSize; i++) {
            char c = s[i];
            if (!freq.count(c) || i - freq[c] > len) {
                len += 1;
            }
            else {
                maxLen = max(maxLen, len);
                len = i - freq[c];
            }
            freq[c] = i;
        }

        return max(maxLen, len);
    }
};



int main() {
    return 0;
}