#include <iostream>


#define MAX 100

int main() {
    int arr[MAX], n;
    std::cin >> n;
    for (int i = 0; i < n; i++) {
        std::cin >> arr[i];
    }
    int even = 0;
    if (arr[0] % 2 == arr[1] % 2 && arr[2] % 2 != arr[0] % 2) {
        even = arr[2] % 2;
    }
    else if (arr[1] % 2 == arr[2] % 2 && arr[0] % 2 != arr[1] % 2) {
        even = arr[0] % 2;
    }
    else if (arr[0] % 2 == arr[2] % 2 && arr[1] % 2 != arr[0] % 2){
        even = arr[1] % 2;
    }
    else {
        even = !(arr[0] % 2);
    }
    for (int i = 0; i < n; i++) {
        if (arr[i] % 2 == even) {
            std::cout << i + 1;
            return 0;
        }
    }
    return 0;
}