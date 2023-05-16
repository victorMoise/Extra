#include <iostream>


int main() {
    int t;
    std::cin >> t;
    while (t--) {
        int a, b, c;
        std::cin >> a >> b >> c;
        (a == b + c || b == a + c || c == a + b) ? std::cout << "YES\n" : std::cout << "NO\n";
    }
    return 0;
}