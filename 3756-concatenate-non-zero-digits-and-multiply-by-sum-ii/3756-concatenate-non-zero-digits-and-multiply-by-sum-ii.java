class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Count non-zero digits
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') k++;
        }

        int[] pos = new int[k];
        int[] digit = new int[k];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                pos[idx] = i;
                digit[idx] = c - '0';
                idx++;
            }
        }

        long[] pow10 = new long[k + 1];
        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefNum = new long[k + 1];
        int[] prefSum = new int[k + 1];

        for (int i = 0; i < k; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digit[i]) % MOD;
            prefSum[i + 1] = prefSum[i] + digit[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;
            int sum = prefSum[right + 1] - prefSum[left];

            long x = (prefNum[right + 1]
                    - prefNum[left] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}