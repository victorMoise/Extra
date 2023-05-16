#include <iostream>
#include <cmath>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *list1 = l1;
        ListNode *list2  = l2;
        ListNode *newList = NULL;
        int carry = 0;

        ListNode *tail = newList;

        while (list1 != NULL || list2 != NULL || carry > 0) {
            int sum = carry;
            if (list1 != NULL) {
                sum += list1->val;
                list1 = list1->next;
            }
            if (list2 != NULL) {
                sum += list2->val;
                list2 = list2->next;
            }
            carry = sum / 10;
            sum = sum % 10;

            ListNode *newNode = new ListNode(sum);
            if (newList == NULL) {
                newList = newNode;
                tail = newNode;
            }
            else {
                tail->next = newNode;
                tail = newNode;
            }
        }

        return newList;
    }
};


int main() {
    return 0;
}