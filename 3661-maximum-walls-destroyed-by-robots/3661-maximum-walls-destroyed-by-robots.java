import java.util.*;

public class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0) return 0;

        long[][] robotsData = new long[n][2];
        for (int i = 0; i < n; i++) {
            robotsData[i][0] = robots[i];
            robotsData[i][1] = distance[i];
        }
        Arrays.sort(robotsData, (a, b) -> Long.compare(a[0], b[0]));

        Arrays.sort(walls);

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            long pos = robotsData[i][0];
            long dist = robotsData[i][1];

            // LEFT
            long leftBoundary = (i == 0) ? -2000000000L : robotsData[i - 1][0] + 1;
            long leftReach = Math.max(leftBoundary, pos - dist);
            int leftWalls = getCount(walls, leftReach, pos);

            // RIGHT
            long rightBoundary = (i == n - 1) ? 2000000000L : robotsData[i + 1][0] - 1;
            long rightReach = Math.min(rightBoundary, pos + dist);
            int rightWalls = getCount(walls, pos, rightReach);

            if (i == 0) {
                dp[i][0] = leftWalls;
                dp[i][1] = rightWalls;
            } else {
                // OPTION 1: prev LEFT (no overlap)
                int option1 = dp[i - 1][0] + leftWalls;

                // OPTION 2: prev RIGHT (handle overlap properly)
                long prevPos = robotsData[i - 1][0];
                long prevDist = robotsData[i - 1][1];
                long prevRightReach = Math.min(pos - 1, prevPos + prevDist);

                // A = [prevPos, prevRightReach]
                int countA = getCount(walls, prevPos, prevRightReach);

                // B = [leftReach, pos]
                int countB = leftWalls;

                // intersection
                long interStart = Math.max(prevPos, leftReach);
                long interEnd = Math.min(prevRightReach, pos);
                int overlap = getCount(walls, interStart, interEnd);

                int unionWalls = countA + countB - overlap;

                int option2 = (i > 1 ? Math.max(dp[i - 2][0], dp[i - 2][1]) : 0) + unionWalls;

                dp[i][0] = Math.max(option1, option2);

                // RIGHT (no overlap issue)
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + rightWalls;
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private int getCount(int[] walls, long start, long end) {
        if (start > end) return 0;
        int l = lowerBound(walls, start);
        int r = upperBound(walls, end);
        return Math.max(0, r - l);
    }

    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int upperBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}