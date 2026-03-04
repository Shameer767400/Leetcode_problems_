import java.util.*;

class Solution {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) return true;

        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        int n = s1.length();

        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int f : freq)
            if (f != 0) {
                memo.put(key, false);
                return false;
            }

        for (int k = 1; k < n; k++) {

            // no swap
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) &&
                isScramble(s1.substring(k), s2.substring(k))) {
                memo.put(key, true);
                return true;
            }

            // swap
            if (isScramble(s1.substring(0, k), s2.substring(n - k)) &&
                isScramble(s1.substring(k), s2.substring(0, n - k))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}