#include "definition.h"


int main() {
    List lista;

    for (int i = 0; i < 10; i++) {
        lista.push_back(i);
    }

    lista.print_list();
    return 0;
}