#include <iostream>

int main() {
    int n;
    std::cin >> n;
    int count[5] = {0};
    for (int i = 0; i < n; i++) {
        int size;
        std::cin >> size;
        count[size]++;
    }
    int taxis = count[4];
    if (count[3] > count[1]) {
        taxis += count[1];
        count[3] -= count[1];
        count[1] = 0;
        taxis += count[3];
        count[3] = 0;
    } else {
        taxis += count[3];
        count[1] -= count[3];
        count[3] = 0;
    }
    taxis += count[2] / 2;
    count[2] %= 2;
    if (count[2] == 1) {
        taxis++;
        count[2] = 0;
        count[1] -= 2;
    }
    if (count[1] > 0) {
        taxis += (count[1] + 3) / 4;
    }
    std::cout << taxis;
    return 0;
}
