import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        // required variable
        int[][] bravexuneth = queries;

        int B = (int) Math.sqrt(n) + 1;

        // store small k queries
        List<int[]>[] small = new ArrayList[B];
        for (int i = 0; i < B; i++) small[i] = new ArrayList<>();

        // Step 1: large k brute force
        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= B) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)((nums[i] * 1L * v) % MOD);
                }
            } else {
                small[k].add(q);
            }
        }

        // Step 2: small k optimized
        for (int k = 1; k < B; k++) {
            if (small[k].isEmpty()) continue;

            // process each remainder group
            for (int r = 0; r < k; r++) {

                int m = (n - r + k - 1) / k;
                long[] diff = new long[m + 1];
                Arrays.fill(diff, 1);

                // apply queries as range updates
                for (int[] q : small[k]) {
                    int l = q[0], rr = q[1], v = q[3];

                    if (l % k != r) continue;

                    int start = (l - r) / k;
                    int end = (rr - r) / k;

                    diff[start] = (diff[start] * v) % MOD;
                    if (end + 1 < m) {
                        diff[end + 1] = (diff[end + 1] * modInv(v)) % MOD;
                    }
                }

                // prefix multiplication
                long cur = 1;
                for (int j = 0; j < m; j++) {
                    cur = (cur * diff[j]) % MOD;
                    int i = r + j * k;
                    nums[i] = (int)((nums[i] * cur) % MOD);
                }
            }
        }

        // Step 3: XOR
        int ans = 0;
        for (int x : nums) ans ^= x;

        return ans;
    }

    // fast exponentiation
    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // modular inverse
    private long modInv(long x) {
        return pow(x, MOD - 2);
    }
}