class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        // base case: empty string
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            // leading zero = invalid
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // take one digit
            dp[i] = dp[i + 1];

            // take two digits if valid
            if (i + 1 < n) {
                int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (val >= 10 && val <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
