class Solution {
public:
    long long gcdll(long long a, long long b) {
        return std::gcd(a, b);
    }

    long long lcmll(long long a, long long b) {
        return a / gcdll(a, b) * b;
    }

    long long countAmounts(long long x, const vector<int>& coins) {
        int n = coins.size();
        long long count = 0;

        // Inclusion-exclusion over all non-empty subsets.
        for (int mask = 1; mask < (1 << n); ++mask) {
            long long l = 1;
            int bits = 0;
            bool overflow = false;

            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    ++bits;

                    long long g = gcdll(l, coins[i]);

                    // Prevent LCM from exceeding x.
                    if (l > x / (coins[i] / g)) {
                        overflow = true;
                        break;
                    }

                    l = l / g * coins[i];

                    if (l > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow)
                continue;

            long long ways = x / l;

            if (bits & 1)
                count += ways;
            else
                count -= ways;
        }

        return count;
    }

    long long findKthSmallest(vector<int>& coins, long long k) {
        // Remove denominations whose multiples are already covered
        // by a smaller denomination.
        sort(coins.begin(), coins.end());

        vector<int> filtered;

        for (int c : coins) {
            bool redundant = false;

            for (int x : filtered) {
                if (c % x == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant)
                filtered.push_back(c);
        }

        coins = filtered;

        long long lo = 1;
        long long hi = 1LL * coins[0] * k;

        while (lo < hi) {
            long long mid = lo + (hi - lo) / 2;

            if (countAmounts(mid, coins) >= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
};