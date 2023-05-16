#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = "";
        int step = 0;
        string first = strs[0];
        int n = strs.size();

        if (n == 1) {
            return strs[0];
        }

        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            int len = strs[i].length();
            if (len > maxSize) {
                maxSize = len;
            }
        }

        for (int i = 0; i < maxSize; i++) {
            int first = strs[0][i];
            int common = 1;
            for (int j = 1; j < n; j++) {
                if (strs[j][i] == first) {
                    common += 1;
                }
            }
            if (common == n) {
                    ans += first;
                }
            else {
                return ans;
            }
        }
        return ans;
    }
};
