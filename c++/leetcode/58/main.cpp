#include <iostream>
#include <cstring>
#include <string>

using namespace std;


class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.size();
        char str[n + 1];

        strcpy(str, s.c_str());
        str[n] = '\0';

        char *ptr = strtok(str, " ");
        char *lastWord;

        while (ptr != NULL) {
            lastWord = ptr;
            ptr = strtok(NULL, " ");
        }

        return strlen(lastWord);
    }
};


int main() {
    return 0;
}