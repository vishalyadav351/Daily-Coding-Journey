import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                
                for (int k = 1; ; k++) {
                    int topR = i, topC = j;
                    int leftR = i + k, leftC = j - k;
                    int rightR = i + k, rightC = j + k;
                    int bottomR = i + 2 * k, bottomC = j;

                    if (leftC < 0 || rightC >= n || bottomR >= m) break;

                    int sum = 0;
                    for (int x = 0; x < k; x++) sum += grid[topR + x][topC - x];
                    for (int x = 0; x < k; x++) sum += grid[leftR + x][leftC + x];
                    for (int x = 0; x < k; x++) sum += grid[bottomR - x][bottomC + x];
                    for (int x = 0; x < k; x++) sum += grid[rightR - x][rightC - x];

                    set.add(sum);
                }
            }
        }
        int count = Math.min(3, set.size());
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
}