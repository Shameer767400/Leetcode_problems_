class Solution {
public:
    string getPermutation(int n, int k) {
        // Precompute factorials up to 9! (since n <= 9)
        vector<int> fact(n + 1, 1);
        for (int i = 1; i <= n; ++i) {
            fact[i] = fact[i - 1] * i;
        }

        // List of available digits
        vector<int> nums;
        for (int i = 1; i <= n; ++i) {
            nums.push_back(i);
        }

        // Convert k to 0-based index
        k--;

        string ans;
        for (int i = n; i >= 1; --i) {
            int blockSize = fact[i - 1];
            int index = k / blockSize;   // choose which digit to pick
            k %= blockSize;              // remaining rank inside the block

            ans.push_back(char('0' + nums[index]));
            nums.erase(nums.begin() + index);
        }

        return ans;
    }
};
