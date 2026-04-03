import java.util.*;

public class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0) return 0;

        // Step 1: Pair and sort robots by position
        long[][] robotsData = new long[n][2];
        for (int i = 0; i < n; i++) {
            robotsData[i][0] = robots[i];
            robotsData[i][1] = distance[i];
        }
        Arrays.sort(robotsData, (a, b) -> Long.compare(a[0], b[0]));

        // Step 2: Sort walls
        Arrays.sort(walls);

        // dp[i][0] → max walls if robot i fires LEFT
        // dp[i][1] → max walls if robot i fires RIGHT
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            long pos = robotsData[i][0];
            long dist = robotsData[i][1];

            // LEFT RANGE
            long leftBoundary = (i == 0) ? -2000000000L : robotsData[i - 1][0] + 1;
            long leftReach = Math.max(leftBoundary, pos - dist);
            int leftWalls = getCount(walls, leftReach, pos);

            // RIGHT RANGE
            long rightBoundary = (i == n - 1) ? 2000000000L : robotsData[i + 1][0] - 1;
            long rightReach = Math.min(rightBoundary, pos + dist);
            int rightWalls = getCount(walls, pos, rightReach);

            if (i == 0) {
                dp[i][0] = leftWalls;
                dp[i][1] = rightWalls;
            } else {
                // Case 1: Previous robot fired LEFT (no overlap)
                int option1 = dp[i - 1][0] + leftWalls;

                // Case 2: Previous robot fired RIGHT (possible overlap → take union)
                long prevPos = robotsData[i - 1][0];
                long prevDist = robotsData[i - 1][1];
                long prevRightReach = Math.min(pos - 1, prevPos + prevDist);

                long unionStart = Math.min(prevPos, leftReach);
                long unionEnd = Math.max(prevRightReach, pos);

                int unionWalls = getCount(walls, unionStart, unionEnd);
                int option2 = (i > 1 ? Math.max(dp[i - 2][0], dp[i - 2][1]) : 0) + unionWalls;

                dp[i][0] = Math.max(option1, option2);

                // RIGHT case (no overlap with previous)
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + rightWalls;
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // Count walls in range [start, end]
    private int getCount(int[] walls, long start, long end) {
        if (start > end) return 0;
        int leftIdx = lowerBound(walls, start);
        int rightIdx = upperBound(walls, end);
        return Math.max(0, rightIdx - leftIdx);
    }

    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int upperBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}