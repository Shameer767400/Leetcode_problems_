class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        
        // Place each number x in position x-1 if possible
        for (int i = 0; i < n; ++i) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap nums[i] with nums[nums[i] - 1]
                int correctIdx = nums[i] - 1;
                swap(nums[i], nums[correctIdx]);
            }
        }
        
        // Find the first place where index+1 != value
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all 1..n are present, answer is n+1
        return n + 1;
    }
};
