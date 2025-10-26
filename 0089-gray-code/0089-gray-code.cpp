class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        int size = 1 << n; // 2^n elements

        for (int i = 0; i < size; ++i) {
            result.push_back(i ^ (i >> 1));
        }

        return result;
    }
};