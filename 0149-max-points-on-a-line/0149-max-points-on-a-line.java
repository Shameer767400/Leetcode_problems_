import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int answer = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(Math.abs(dx), Math.abs(dy));

                dx /= g;
                dy /= g;

                // Normalize slope
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                }

                String slope = dy + "," + dx;

                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                answer = Math.max(answer, count + 1);
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}