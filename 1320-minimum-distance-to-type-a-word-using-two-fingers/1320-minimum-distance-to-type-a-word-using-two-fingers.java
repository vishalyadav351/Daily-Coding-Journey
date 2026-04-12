class Solution {
    public int minimumDistance(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        int[] dp = new int[27];
        java.util.Arrays.fill(dp, 0); 
        for (int i = 0; i < n - 1; i++) {
            int currentPos = chars[i] - 'A';
            int nextPos = chars[i + 1] - 'A';
            
            int[] nextDp = new int[27];
            java.util.Arrays.fill(nextDp, 2000); 
            for (int other = 0; other <= 26; other++) {
                if (dp[other] == 2000) continue;
                int dist1 = calculateGap(currentPos, nextPos);
                nextDp[other] = Math.min(nextDp[other], dp[other] + dist1);
                int dist2 = (other == 26) ? 0 : calculateGap(other, nextPos);
                nextDp[currentPos] = Math.min(nextDp[currentPos], dp[other] + dist2);
            }
            dp = nextDp;
        }   
        int finalAns = 2000;
        for (int d : dp) finalAns = Math.min(finalAns, d);
        
        return finalAns;
    }
     private int calculateGap(int p1, int p2) {
        int x1 = p1 / 6, y1 = p1 % 6;
        int x2 = p2 / 6, y2 = p2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
   