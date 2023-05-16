#include "definition.h"
#include <iostream>

void List::push_back(int value) {
    Node *newNode = new Node();
    
    newNode->data = value;
    newNode->next = NULL;
    newNode->prev = NULL;
    lenght += 1;

    if (head == NULL) {
        head = newNode;
        return;
    }

    Node *temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    return;
}


void List::print_list() {
    Node *temp = head;

    while (temp != NULL) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }

    return;
}