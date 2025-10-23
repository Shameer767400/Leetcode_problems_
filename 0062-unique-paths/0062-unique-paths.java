class Solution {
    public int uniquePaths(int m, int n) {
        return combination(m + n - 2, Math.min(m - 1, n - 1));
    }

    private int combination(int total, int choose) {
        long result = 1;
        for (int i = 1; i <= choose; i++) {
            result = result * (total - i + 1) / i;
        }
        return (int) result;
    }
}