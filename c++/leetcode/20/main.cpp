#include <unordered_map>
#include <stack>
#include <iostream>


using namespace std;


class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        unordered_map<char, char> brackets = {{'(', ')'}, {'[', ']'}, {'{', '}'}};

        for (char c : s) {
            //if the current charcater is an open bracket push it to the stack
            if (brackets.count(c)) {
                st.push(c);
            }
            //if it's a close bracket check if it matches the top element   
            else {
                if (st.empty() || brackets[st.top()] != c) {
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }
        return st.empty();
    }
};


class AnotherSolution {
public:
    bool isValid(string s) {
        string left;
        for(auto &c : s) {
            if(c == '(' || c == '{' || c == '[') left.push_back(c);
            else {
                if((c == ')' && left.back() == '(') ||
                (c == '}' && left.back() == '{') ||
                (c == ']' && left.back() == '['))
                    left.pop_back();
                else
                 return false;
            }
        }
        return left.empty();
    }
};