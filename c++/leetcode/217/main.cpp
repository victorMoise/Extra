#include <iostream>
#include <unordered_set>
#include <vector>


class Solution {
public:
    bool containsDuplicate(std::vector<int>& nums) {
        std::unordered_set<int> freq;
        for (auto x : nums) {
            if (freq.find(x) == freq.end()) {
                freq.emplace(x);
            }
            else {
                return true;
            }
        }
        return false;
    }
};


int main() {
    return 0;
}