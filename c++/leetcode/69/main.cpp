#include <iostream>
#include <cmath>

using namespace std;


class Solution {
public:
    int mySqrt(int number) {
        unsigned long long ans = 0;
        int left = 0, right = number;
        while (left <= right) {
            unsigned long long middle = (left + right) / 2;
            unsigned long long doubleMid = middle * middle;
            if (doubleMid == number) {
                return middle;
            }
            else if (doubleMid < number) {
                left = middle + 1;
                ans = left;
            }
            else {
                right = middle - 1;
            }
        }
        if (ans * ans == number) {
            return ans;
        }
        else {
            return ans - 1;
        }
    }
};


int main() {
    
    return 0;
}