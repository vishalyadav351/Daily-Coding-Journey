class Solution {
    public boolean canPartition(int[][] grid) {
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
       
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long target = totalSum / 2;
        
       
        long horizontalAccumulator = 0;
        for (int i = 0; i < m - 1; i++) {  
            horizontalAccumulator += rowSums[i];
            if (horizontalAccumulator == target) {
                return true;
            }
        }
        
       
        long verticalAccumulator = 0;
        for (int j = 0; j < n - 1; j++) {  
            verticalAccumulator += colSums[j];
            if (verticalAccumulator == target) {
                return true;
            }
        }
        
        return false;
    }
}