#include <vector>

using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.empty()) {
            return 0;
        }
        int i = 0;
        int size = nums.size();
        for (int j = 0; j < size; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
};


int main() {
    return 0;
}