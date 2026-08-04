    class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean is_negative = (dividend < 0) ^ (divisor < 0);
       
        long dvd = dividend;
        long dvs = divisor;
        
        dvd = dvd < 0 ? -dvd : dvd;
        dvs = dvs < 0 ? -dvs : dvs;
        
        long quotient = 0;
        
        while (dvd >= dvs) {
            long temp_divisor = dvs;
            long multiple = 1;
            
            while (dvd >= (temp_divisor << 1)) {
                temp_divisor <<= 1;
                multiple <<= 1;
            }
            
            dvd -= temp_divisor;
            quotient += multiple;
        }
       
        long result = is_negative ? -quotient : quotient;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) result;
    }
}