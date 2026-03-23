class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;

        long[][] maxP = new long[m][n];
        long[][] minP = new long[m][n];

        maxP[0][0] = minP[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxP[i][0] = minP[i][0] = maxP[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxP[0][j] = minP[0][j] = maxP[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                
                                long a = maxP[i - 1][j] * val;
                long b = maxP[i][j - 1] * val;
                long c = minP[i - 1][j] * val;
                long d = minP[i][j - 1] * val;

                maxP[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minP[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long res = maxP[m - 1][n - 1];
                return res < 0 ? -1 : (int) (res % MOD);
    }
}