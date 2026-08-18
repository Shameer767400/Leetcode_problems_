class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] count = new int[51];

        int n = nums.length;

        // Generate every subarray of size k
        for (int start = 0; start <= n - k; start++) {

            boolean[] seen = new boolean[51];

            for (int i = start; i < start + k; i++) {
                seen[nums[i]] = true;
            }

            // Count each number only once per window
            for (int x = 0; x <= 50; x++) {
                if (seen[x]) {
                    count[x]++;
                }
            }
        }

        // Find largest number appearing in exactly one window
        for (int x = 50; x >= 0; x--) {
            if (count[x] == 1) {
                return x;
            }
        }

        return -1;
    }
}