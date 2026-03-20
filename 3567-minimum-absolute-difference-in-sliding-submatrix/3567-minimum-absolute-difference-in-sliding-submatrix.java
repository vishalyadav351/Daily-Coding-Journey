import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int resM = m - k + 1;
        int resN = n - k + 1;
        int[][] ans = new int[resM][resN];

        for (int i = 0; i < resM; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int r = i; r < i + k; r++) {
                for (int c = 0; c < k; c++) {
                    map.put(grid[r][c], map.getOrDefault(grid[r][c], 0) + 1);
                }
            }
            
            ans[i][0] = calculateMin(map);

            for (int j = 1; j < resN; j++) {
                for (int r = i; r < i + k; r++) {
                    int out = grid[r][j - 1];
                    if (map.get(out) == 1) map.remove(out);
                    else map.put(out, map.get(out) - 1);
                }
                
                for (int r = i; r < i + k; r++) {
                    int in = grid[r][j + k - 1];
                    map.put(in, map.getOrDefault(in, 0) + 1);
                }
                
                ans[i][j] = calculateMin(map);
            }
        }
        return ans;
    }

    private int calculateMin(TreeMap<Integer, Integer> map) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        
        for (int curr : map.keySet()) {
            if (prev != null) {
                minDiff = Math.min(minDiff, curr - prev);
            }
            prev = curr;
            
            if (minDiff == 1) return 1;
        }
        
        return (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
    }
}