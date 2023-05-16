#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


class Solution {
public:
    string addBinary(string a, string b) {
        string ans;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a[i] - '0';
                i -= 1;
            }
            if (j >= 0) {
                carry += b[j] - '0';
                j -= 1;
            }
            ans += (carry % 2) + '0';
            carry /= 2;
            
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};


int main() {
    return 0;
}