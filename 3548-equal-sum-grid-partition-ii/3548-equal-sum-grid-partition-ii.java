import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        long[] rowSums = new long[m];
        long[] colSums = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
        }

        // 1. Horizontal Cuts
        long topSum = 0;
        // Use a Set to track values in the current top section
        Set<Integer> topSet = new HashSet<>();
        // Use a Map to track frequencies in the bottom section
        Map<Integer, Integer> bottomFreq = new HashMap<>();
        for (int[] row : grid) {
            for (int val : row) bottomFreq.put(val, bottomFreq.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < m - 1; i++) {
            topSum += rowSums[i];
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                topSet.add(val);
                bottomFreq.put(val, bottomFreq.get(val) - 1);
            }
            if (isValid(topSum, totalSum - topSum, 0, i, 0, n - 1, i + 1, m - 1, 0, n - 1, grid, topSet, bottomFreq)) 
                return true;
        }

        // 2. Vertical Cuts
        long leftSum = 0;
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightFreq = new HashMap<>();
        for (int[] row : grid) {
            for (int val : row) rightFreq.put(val, rightFreq.getOrDefault(val, 0) + 1);
        }

        for (int j = 0; j < n - 1; j++) {
            leftSum += colSums[j];
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                leftSet.add(val);
                rightFreq.put(val, rightFreq.get(val) - 1);
            }
            if (isValid(leftSum, totalSum - leftSum, 0, m - 1, 0, j, 0, m - 1, j + 1, n - 1, grid, leftSet, rightFreq)) 
                return true;
        }

        return false;
    }

    private boolean isValid(long s1, long s2, int r1s, int r1e, int c1s, int c1e, 
                            int r2s, int r2e, int c2s, int c2e, int[][] grid, 
                            Set<Integer> f1, Map<Integer, Integer> f2) {
        if (s1 == s2) return true;
        
        if (s1 > s2) {
            long target = s1 - s2;
            if (target > 100000 || !f1.contains((int)target)) return false;
            return check1D(grid, (int)target, r1s, r1e, c1s, c1e);
        } else {
            long target = s2 - s1;
            if (target > 100000 || f2.getOrDefault((int)target, 0) <= 0) return false;
            return check1D(grid, (int)target, r2s, r2e, c2s, c2e);
        }
    }

    private boolean check1D(int[][] grid, int t, int rs, int re, int cs, int ce) {
        int rows = re - rs + 1;
        int cols = ce - cs + 1;
        
        // If it's a 1D strip (one dimension is 1), only the two ends are valid
        if (rows == 1) {
            return grid[rs][cs] == t || grid[rs][ce] == t;
        }
        if (cols == 1) {
            return grid[rs][cs] == t || grid[re][cs] == t;
        }
        
        // If it's 2D, any cell can be discounted and it stays connected
        return true;
    }
}