#include <iostream>
#include <unordered_set>


class Solution {
public:
    bool isHappy(int n) {
        std::unordered_set<int> nums;
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (nums.find(sum) != nums.end()) {
                return false;
            }
            nums.insert(sum);
            n = sum;
        }
        return true;
    }
};


int main() {
    return 0;
}