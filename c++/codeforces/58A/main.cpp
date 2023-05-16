#include <iostream>
#include <string>


int main() {
    std::string s;
    std::cin >> s;

    int letters = 0;
    for (auto c : s) {
        if (c == "hello"[letters]) {
            letters += 1;
        }
        if (letters == 5) {
            std::cout << "YES";
            return 0;
        }
    }

    std::cout << "NO";
    return 0;
}