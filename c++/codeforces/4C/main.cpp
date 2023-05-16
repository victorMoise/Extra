#include <iostream>
#include <map>
#include <vector>

int main() {
    std::map<std::string, int> freq;
    int n;
    std::cin >> n;
    for (int i = 0; i < n; i++) {
        std::string username;
        std::cin >> username;
        if (freq.count(username) == 0) {
            freq[username] = 1;
            std::cout << "OK\n";
        }
        else {
            std::cout << username << freq[username] << "\n";
            freq[username] += 1;
        }
    }
    return 0;
}