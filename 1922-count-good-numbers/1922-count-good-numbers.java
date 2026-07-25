class Solution {
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int) ((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}