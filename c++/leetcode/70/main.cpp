#include <iostream>


class Solution {
public:
    int climbStairs(int n) {
        int one = 1, two = 1;

        for (int i = 0; i < n; i++) {
            int sum = one + two;
            one = two;
            two = sum;
        }

        return two;
    }
};


int main() {
    return 0;
}