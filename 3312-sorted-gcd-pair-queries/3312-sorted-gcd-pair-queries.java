class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];

        // Count pairs having gcd exactly i
        for (int i = max; i >= 1; i--) {
            long total = 0;
            for (int j = i; j <= max; j += i) {
                total += freq[j];
            }

            cnt[i] = total * (total - 1) / 2;

            for (int j = i * 2; j <= max; j += i) {
                cnt[i] -= cnt[j];
            }
        }

        // Prefix sums of pair counts
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            long target = queries[k] + 1;

            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[k] = l;
        }

        return ans;
    }
}