#include <iostream>


int main() {
    int a, b, c;
    std::cin >> a >> b >> c;
    int ans = a + b + c;
    ans = std::max(ans, ((a + b) * c));
    ans = std::max(ans, (a * (b + c)));
    ans = std::max(ans, (a * b * c));
    std::cout << ans;
    return 0;
}