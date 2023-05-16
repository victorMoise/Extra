class Solution {
public:
    bool isPalindrome(int x) {
    // Check if the number is negative, which is not a palindrome
    if (x < 0) {
        return false;
    }

    // Check if the number is a palindrome by comparing the digits at
    // the beginning and end of the number
    long long reversed = 0;
    int temp = x;
    while (temp > 0) {
        reversed = (reversed * 10) + (temp % 10);
        temp /= 10;
    }
    return reversed == x;
    }
};


int main() {
    return 0;
}