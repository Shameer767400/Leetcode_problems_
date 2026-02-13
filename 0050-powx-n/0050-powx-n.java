class Solution {
    public double myPow(double x, int n) {
        long N = n;          // use long to avoid overflow when n = Integer.MIN_VALUE
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double current = x;

        while (N > 0) {
            if ((N & 1) == 1) {   // if exponent is odd
                result *= current;
            }
            current *= current;   // square the base
            N >>= 1;              // divide exponent by 2
        }

        return result;
    }
}
