struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummy(0);
        ListNode* curr = &dummy;

        // While both lists are non-empty, compare their first elements and
        // append the smaller one to the merged list
        while (list1 && list2) {
            if (list1->val <= list2->val) {
                curr->next = list1;
                list1 = list1->next;
            } else {
                curr->next = list2;
                list2 = list2->next;
            }
            curr = curr->next;
        }

        // Append the remaining elements of the non-empty list (if any) to the merged list
        if (list1) {
            curr->next = list1;
        } else if (list2) {
            curr->next = list2;
        }

        // Return the head of the merged list (which is the next field of the dummy node)
        return dummy.next;
    }
};
