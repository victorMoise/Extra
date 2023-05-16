#include <iostream>
#include <vector>

#define N 1001

int main() {
    std::vector<std::pair<int, int>> enemy(N);
    int power, n;
    std::cin >> power >> n;
    for (int i = 0; i < n; i++) {
        std::cin >> enemy[i].first >> enemy[i].second;
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (enemy[i].first > enemy[j].first) {
                swap(enemy[i], enemy[j]);
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (enemy[i].first >= power) {
            std::cout << "NO";
            return 0;
        }
        else {
            power += enemy[i].second;
        }
    }
    std::cout << "YES";
    return 0;
}