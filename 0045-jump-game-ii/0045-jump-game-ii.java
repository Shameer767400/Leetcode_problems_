class Solution {
    public int jump(int[] nums) {
        int sz = nums.length;
        if (sz < 2) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = 0;
        while (r < sz - 1) {
            int mx = 0;
            for (int i = l; i <= r; i++) {
                if (i + nums[i] > mx) {
                    mx = i + nums[i];
                }
            }
            l = r + 1;
            r = mx;
            ans++;
        }
        return ans;
    }
}