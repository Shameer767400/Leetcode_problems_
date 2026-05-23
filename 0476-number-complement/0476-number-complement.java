class Solution {
    public int findComplement(int num) {
        int mask = 0;

        int temp = num;

        // Create mask like 111... based on number of bits
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return num ^ mask;
    }
}