class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    private boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] != target[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    private void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }
}