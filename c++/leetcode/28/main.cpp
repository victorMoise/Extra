#include <iostream>


class Solution {
public:
    int strStr(std::string haystack, std::string needle) {
        int pos = haystack.find(needle);
        if (pos == std::string::npos) {
            return -1;
        }
        else {
            return pos;
        }
    }
};


int main() {
    Solution s;
    std::string needle, haystack;
    std::cin >> haystack >> needle;
    std::cout << s.strStr(haystack, needle);
    return 0;
}