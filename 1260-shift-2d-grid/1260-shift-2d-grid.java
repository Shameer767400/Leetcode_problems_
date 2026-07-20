import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < total; i++) {
            int newIndex = (i + k) % total;

            shifted[newIndex / n][newIndex % n] = grid[i / n][i % n];
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}