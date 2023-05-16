

struct Node {
    int data;
    Node *next;
    Node *prev;
};


class List {
private:
    Node *head;
    int lenght;
    
public:
    void push_back(int value);
    void print_list();

};

