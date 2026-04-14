import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
                Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
                List<Long> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add((long) f[0]);
            }
        }
        
        int n = robot.size();
        int m = factoryPositions.size();
                long[] dp = new long[n + 1];
                long INF = 1000000000000000L; 
        Arrays.fill(dp, INF);
        dp[0] = 0; 
                for (int j = 0; j < m; j++) {
            long fPos = factoryPositions.get(j);
            for (int i = n; i >= 1; i--) {
                long currentDist = Math.abs((long)robot.get(i - 1) - fPos);
            
                if (dp[i - 1] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - 1] + currentDist);
                }
            }
        }
        
        return dp[n];
    }
}