#include <iostream>


bool isLucky(int n) {
    while (n > 0) {
        int digit = n % 10;
        if (digit != 4 && digit != 7) {
            return false;
        }
        n /= 10;
    }
    return true;
}


int main() {
    int n;
    std::cin >> n;
    for (int i = 1; i <= n; i++) {
        if (n % i == 0 && isLucky(i)) {
            std::cout << "YES\n";
            return 0;
        }
    }
    std::cout << "NO\n";
    return 0;
}