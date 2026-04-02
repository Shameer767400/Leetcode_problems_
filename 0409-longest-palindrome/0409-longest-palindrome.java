class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII
        
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }
        
        if (hasOdd) length += 1;
        
        return length;
    }
}
