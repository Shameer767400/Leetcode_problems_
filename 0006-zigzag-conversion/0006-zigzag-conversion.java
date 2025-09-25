class Solution {
    public String convert(String s, int numRows) {
        // Edge case: only one row → return original string
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        // Place each character in the correct row
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);

            // When we hit top or bottom row, reverse direction
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            curRow += goingDown ? 1 : -1;
        }

        // Combine all rows into final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
