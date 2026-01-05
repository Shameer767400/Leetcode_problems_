class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts, StringBuilder current, List<String> result) {
        // If we have 4 parts and consumed all characters → valid IP
        if (parts == 4 && index == s.length()) {
            result.add(current.toString());
            return;
        }

        // If parts exceed 4 or characters run out incorrectly → dead end
        if (parts == 4 || index == s.length()) return;

        int lenBefore = current.length();

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            // No leading zero unless single digit
            if (len > 1 && s.charAt(index) == '0') break;

            String part = s.substring(index, index + len);
            int value = Integer.parseInt(part);

            if (value > 255) break;

            if (current.length() > 0) current.append('.');
            current.append(part);

            backtrack(s, index + len, parts + 1, current, result);

            current.setLength(lenBefore); // undo
        }
    }
}
