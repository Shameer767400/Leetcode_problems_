class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];

        // Phase 1: before
        while (i < n && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: overlap
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});

        // Phase 3: after
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
