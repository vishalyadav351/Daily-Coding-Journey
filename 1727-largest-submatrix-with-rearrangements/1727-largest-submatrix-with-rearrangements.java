import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            
            int[] currentRow = matrix[i].clone();
            Arrays.sort(currentRow);

            for (int k = 0; k < n; k++) {
                int height = currentRow[n - 1 - k];
                int width = k + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}