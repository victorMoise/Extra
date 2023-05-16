#include <iostream>
#include <vector>


class Solution {
public:
    std::vector<int> getRow(int rowIndex) {
        std::vector<int> prevRow(1, 1);
        for (int i = 1; i < rowIndex; i++) {
            std::vector<int> currRow(i + 1, 1);
            for (int j = 1; j < i; j++) {
                currRow[j] = prevRow[j - 1] + prevRow[j];
            }
            prevRow = currRow;
        }

        return prevRow;
    }
};


int main() {
    return 0;
}