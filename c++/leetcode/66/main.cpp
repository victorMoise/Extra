#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int vectorSize = digits.size();

        int carry = 1;
        for (int i = vectorSize - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (carry > 0) {
            digits.insert(digits.begin(), carry);
        }

        return digits;
    }

};


int main() {
    return 0;
}