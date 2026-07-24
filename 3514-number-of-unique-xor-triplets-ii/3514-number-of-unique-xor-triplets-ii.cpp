class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        const int MAXX = 2048;   // 2^11

        vector<char> dp(MAXX, 0), ndp(MAXX, 0);
        dp[0] = 1;

        for (int step = 0; step < 3; step++) {
            fill(ndp.begin(), ndp.end(), 0);
            for (int x = 0; x < MAXX; x++) {
                if (!dp[x]) continue;
                for (int v : nums) {
                    ndp[x ^ v] = 1;
                }
            }
            dp.swap(ndp);
        }

        int ans = 0;
        for (char ok : dp) ans += ok;
        return ans;
    }
};