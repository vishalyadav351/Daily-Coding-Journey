class Solution {
    public int maximumAmount(int[][] coins) {
        int rows = coins.length;
        int cols = coins[0].length;
        
        
        long[][][] vault = new long[rows][cols][3];
        
        long negInf = (long) -1e15; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 3; k++) {
                    vault[i][j][k] = negInf;
                }
            }
        }

        int firstCell = coins[0][0];
        vault[0][0][0] = firstCell; 
        if (firstCell < 0) {
            vault[0][0][1] = 0; 
            vault[0][0][2] = 0; 
        } else {
            vault[0][0][1] = firstCell;
            vault[0][0][2] = firstCell;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) continue;

                for (int k = 0; k < 3; k++) {
                    long bestFromPrev = negInf;
                    
                    if (r > 0) bestFromPrev = Math.max(bestFromPrev, vault[r - 1][c][k]);
                    if (c > 0) bestFromPrev = Math.max(bestFromPrev, vault[r][c - 1][k]);

                    vault[r][c][k] = Math.max(vault[r][c][k], bestFromPrev + coins[r][c]);


                    if (coins[r][c] < 0 && k > 0) {
                        long powerBefore = negInf;
                        if (r > 0) powerBefore = Math.max(powerBefore, vault[r - 1][c][k - 1]);
                        if (c > 0) powerBefore = Math.max(powerBefore, vault[r][c - 1][k - 1]);
                        
                        vault[r][c][k] = Math.max(vault[r][c][k], powerBefore);
                    }
                }
            }
        }

        long finalResult = vault[rows - 1][cols - 1][0];
        finalResult = Math.max(finalResult, vault[rows - 1][cols - 1][1]);
        finalResult = Math.max(finalResult, vault[rows - 1][cols - 1][2]);

        return (int) finalResult;
    }
}