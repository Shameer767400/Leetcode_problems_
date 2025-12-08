class Solution {
public:
    int findFirst(const vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;          // possible first
                high = mid - 1;     // search left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    int findLast(const vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;          // possible last
                low = mid + 1;      // search right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return {-1, -1}; // not found
        int last = findLast(nums, target);
        return {first, last};
    }
};
