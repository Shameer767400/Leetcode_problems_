class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();
        
        while (num != 0) {
            int last4 = num & 15;   // get last 4 bits
            result.append(map[last4]);
            num >>>= 4;            // unsigned shift
        }
        
        return result.reverse().toString();
    }
}
