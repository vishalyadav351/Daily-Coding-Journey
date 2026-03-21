class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int row1 = x + i;
            int row2 = x + k - 1 - i;
            
            for (int j = y; j < y + k; j++) {
                int temp = grid[row1][j];
                grid[row1][j] = grid[row2][j];
                grid[row2][j] = temp;
            }
        }
        return grid;
    }
}