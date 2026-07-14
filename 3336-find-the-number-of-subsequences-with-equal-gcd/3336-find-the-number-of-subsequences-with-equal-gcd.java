class Solution {
    private static final int MOD = 1_000_000_007;
    private int[] nums;
    private int n;
    private int[][][] dp;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        dp = new int[n][201][201];

        for (int i = 0; i < n; i++) {
            for (int g1 = 0; g1 <= 200; g1++) {
                Arrays.fill(dp[i][g1], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != -1) {
            return dp[idx][g1][g2];
        }

        long ans = dfs(idx + 1, g1, g2); // Skip

        ans += dfs(idx + 1, gcd(g1, nums[idx]), g2); // Put in seq1
        ans %= MOD;

        ans += dfs(idx + 1, g1, gcd(g2, nums[idx])); // Put in seq2
        ans %= MOD;

        return dp[idx][g1][g2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}