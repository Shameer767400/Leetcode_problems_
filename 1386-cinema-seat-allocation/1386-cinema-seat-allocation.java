import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> rows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNumber = seat[1];

            rows.put(
                row,
                rows.getOrDefault(row, 0) | (1 << (seatNumber - 1))
            );
        }
        int LEFT = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);
        int MIDDLE = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);
        int RIGHT = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);
        int answer = 2 * n;
        for (int mask : rows.values()) {

            boolean leftFree = (mask & LEFT) == 0;
            boolean middleFree = (mask & MIDDLE) == 0;
            boolean rightFree = (mask & RIGHT) == 0;

            int groups;

            if (leftFree && rightFree) {
                groups = 2;
            } else if (leftFree || middleFree || rightFree) {
                groups = 1;
            } else {
                groups = 0;
            }
            answer += groups - 2;
        }

        return answer;
    }
}