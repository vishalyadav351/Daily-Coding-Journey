class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
          int[][] countX = new int[rows + 1][cols + 1];
        int[][] countY = new int[rows + 1][cols + 1];
        
        int result = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
             countX[r + 1][c + 1] = countX[r][c + 1] + countX[r + 1][c] - countX                    [r][c] + (grid[r][c] == 'X' ? 1 : 0);
                countY[r + 1][c + 1] = countY[r][c + 1] + countY[r + 1][c] - countY           [r][c] + (grid[r][c] == 'Y' ? 1 : 0);
                
                                if (countX[r + 1][c + 1] == countY[r + 1][c + 1] && countX[r + 1][c + 1] > 0) {
                    result++;
                }
            }
        }
        
        return result;
    }
}