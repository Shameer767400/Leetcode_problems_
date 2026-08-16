class Solution {
    public int smallestNumber(int n, int t) {
        for (int x = n; x <= n + 9; x++) {
            int temp = x;
            int product = 1;

            while (temp > 0) {
                product *= temp % 10;
                temp /= 10;
            }

            if (product % t == 0) {
                return x;
            }
        }

        return -1; // unreachable
    }
}