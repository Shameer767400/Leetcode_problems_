class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Step 2: check overlap
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }

        // add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}

