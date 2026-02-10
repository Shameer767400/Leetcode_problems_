class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        // 2. Handle sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        // 3. Convert digits with overflow check
        int num = 0;
        int INT_MAX = Integer.MAX_VALUE; //  2147483647
        int INT_MIN = Integer.MIN_VALUE; // -2147483648

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Overflow check BEFORE multiplying
            if (num > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }
}
