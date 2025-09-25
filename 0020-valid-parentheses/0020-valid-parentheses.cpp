#include <stack>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        unordered_map<char, char> matching = {
            {')', '('},
            {']', '['},
            {'}', '{'}
        };

        for (char c : s) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);  // push opening bracket
            } else {
                // if stack is empty or top doesn't match
                if (st.empty() || st.top() != matching[c]) {
                    return false;
                }
                st.pop();  // matched, remove from stack
            }
        }

        return st.empty(); // all brackets matched
    }
};
