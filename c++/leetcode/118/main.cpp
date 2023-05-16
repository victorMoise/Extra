#include <iostream>
#include <vector>


class Solution {
public:
    std::vector<std::vector<int>> generate(int numRows) {
        std::vector<std::vector<int>> rows;
        for (int i = 0; i < numRows; i++) {
            std::vector<int> row(i + 1, 1);
            for (int j = 1; j < i; j++) {
                row[j] = rows[i - 1][j - 1] + rows[i - 1][j];
            } 
            rows.push_back(row);               
        }
        return rows;
    }
};


int main() {
    return 0;
}