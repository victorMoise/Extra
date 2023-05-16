#include <iostream>


int main() {
    int t;
    std::cin >> t;
    while (t--) {
        int v[3];
        std::cin >> v[0] >> v[1] >> v[2];
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        std::cout << v[1] << "\n";
    }
    return 0;
}