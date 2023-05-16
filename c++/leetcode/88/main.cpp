#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> merged(n);
        int pos1 = 0, pos2 = 0, pos = 0;

        while (pos1 < m && pos2 < n) {
            if (nums1[pos1] <= nums2[pos2]) {
                merged[pos++] = nums1[pos1];
            }
            else {
                merged[pos++] = nums2[pos];
            }
        }

        while (pos1 < m) {
            merged[pos++] = nums1[pos1++];
        }

        while (pos2 < n) {
            merged[pos++] = nums2[pos2++];
        }

        for (int i = 0; i < m; i++) {
            nums1[i] = merged[i];
        }
    }
};


int main() {
    return 0;
}