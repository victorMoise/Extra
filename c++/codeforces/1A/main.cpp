#include <iostream>


int main() {
    long long n, m, a;
    std::cin >> n >> m >> a;

    long long width = (n + a - 1) / a;
    long long height = (m + a - 1) / a;
    long long total = width * height;

    std::cout << total;

    return 0;
}